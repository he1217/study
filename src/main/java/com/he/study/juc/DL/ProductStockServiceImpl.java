package com.he.study.juc.DL;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2021/4/8 16:05
 */

import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class ProductStockServiceImpl {
    private Jedis jedis = new Jedis("192.168.3.235");


    /**
     * 扣减库存
     *
     * @param productId
     * @param bypPoductStock
     */
    @Transactional(rollbackFor = Exception.class)
    public void reduceProductStock(Integer productId, Integer bypPoductStock) {

        Map<Lock, Integer> lockSeqMap = new ConcurrentHashMap();

        // 1 查询商品库存是否大于购买库存0
        ProductStock productStock = new ProductStock(12, 10, 10, 10, 10, 10, 10);
        if (productStock == null) {
            return;
        }
        Integer stock01 = productStock.getStock01();
        Integer stock02 = productStock.getStock02();
        Integer stock03 = productStock.getStock03();
        Integer stock04 = productStock.getStock04();
        Integer stock05 = productStock.getStock05();

        Integer sumStock = stock01 + stock02 + stock03 + stock04 + stock05;
        if (bypPoductStock > sumStock) {
            throw new ServiceException("库存数量不足");
        }

        // 2 分布式分段加锁
        //  1 做一个随机算法

        //获取商品的segment 分段值
        Integer stockSegment = productStock.getStockSegment();
        // 随机一个 segment 区间    1 ～ segment
        Integer seq = getSegmentSeq(stockSegment);

        Lock lock = new ReentrantLock();//获取锁
        // RLock lock = redissonClient.getLock("product_stock_segment_seq" + seq);

        try {

            lock.lock();

            boolean findOthersStock = false;
            //如果此分段库存为0的情况下
            Integer productStockBySegment = getProductStockBySegment(productId, seq);
            if (productStockBySegment == 0) {
                //释放锁
                lock.unlock();

                /**
                 * 查找下一个segment 段段库存
                 */
                for (java.lang.Integer i = 1; i <= stockSegment; i++) {
                    //过滤上一个segment
                    if (i.equals(seq)) {
                        lockSeqMap.put(lock, i);
                        continue;
                    }

                    lock = new ReentrantLock();//获取分段锁
                    //lock = redissonClient.getLock("product_stock_segment_seq" + i);

                    productStockBySegment = getProductStockBySegment(productId, i);

                    /**
                     * 找到之后直接break；
                     */
                    if (productStockBySegment != 0) {
                        seq = i;
                        findOthersStock = true;
                        lockSeqMap.put(lock, i);
                        break;
                    } else {
                        findOthersStock = false;
                        lock.unlock();
                    }

                }


                /**
                 * 库存不足
                 */
                if (!findOthersStock) {
                    throw new ServiceException("库存不足");
                }


            }


            // 如果库存分段正好大于要购买的数量
            if (productStockBySegment >= bypPoductStock) {
                //扣减库存 segmengt 段段库存
                reduceProductSegmentStock(productId, bypPoductStock, seq);
                log.info("update segmengt stock  success  ...");
                //realse
                lock.unlock();

            }

            // 代码走到这里，就证明说，当前这个分段的库存小于要购买的数量，合并分段加锁

            //
            Integer totalStock = productStockBySegment;

            Map<Lock, Integer> otherLocks = new ConcurrentHashMap(seq);

            //
            for (java.lang.Integer i = 1; i <= stockSegment; i++) {
                if (i.equals(seq)) {
                    lockSeqMap.put(lock, i);
                    continue;

                }
                Lock otherLock =new ReentrantLock();//获取分段锁
                //RLock otherLock = redissonClient.getLock("product_stock_segment_seq" + i);
                Integer productStockBySegment1 = getProductStockBySegment(productId, i);
                if (productStockBySegment1 == 0) {
                    otherLock.unlock();
                }

                if (productStockBySegment1 != 0) {
                    totalStock += productStockBySegment1;
                    otherLocks.put(otherLock, productStockBySegment1);
                    //添加
                    lockSeqMap.put(otherLock, i);
                }

                if (totalStock >= bypPoductStock) {
                    break;
                }


            }
            if (totalStock < bypPoductStock) {
                otherLocks.keySet().forEach(e -> {
                    log.info("释放锁成功");
                    e.unlock();
                });
                throw new ServiceException("所有的库存segment不足");

            }


            /**
             * productStockBySegment 为第一次
             */
            Integer remainReducingStock = bypPoductStock - productStockBySegment;
            //把第一个seq 扣减 为0
            reduceProductSegmentStock(productId, getProductStockBySegment(productId, seq), seq);
            lock.unlock();
            // 3 合并分段加锁 (每一segment 小于 购买库存数量)


            for (Map.Entry<Lock, Integer> otherLockEntry : otherLocks.entrySet()) {
                if (remainReducingStock == 0) {
                    break;
                }

                Integer otherLockSeq = lockSeqMap.get(otherLockEntry.getKey());
                if (otherLockSeq != null) {
                    log.info("otherLockSeq:" + otherLockSeq);
                    Integer otherStock = otherLockEntry.getValue();
                    Lock otherLockEntryKey = otherLockEntry.getKey();
                    //如果还是不足
                    if (remainReducingStock > otherStock) {
                        remainReducingStock -= otherStock;
                        reduceProductSegmentStock(productId, getProductStockBySegment(productId, otherLockSeq), otherLockSeq);

                    } else {
                        //如果是存在
                        reduceProductSegmentStock(productId, remainReducingStock, otherLockSeq);
                        //
                        remainReducingStock = 0;


                    }

                    otherLockEntryKey.unlock();
                }


            }

            // 4 释放锁

        } catch (Exception e) {
            e.printStackTrace();

        } finally {


        }

    }

    /**
     * 扣减segment库存
     *
     * @param productId
     * @param bypPoductStock
     */
    public void reduceProductSegmentStock(Integer productId, Integer bypPoductStock, Integer segmentIdSeq) {

        ProductStock productStockDb = new ProductStock(12, 10, 10, 10, 10, 10, 10);
        ;


        ProductStock productStock = new ProductStock();
        productStock.setId(productId);

        String fieldName = null;
        if (segmentIdSeq >= 1 && segmentIdSeq <= 9) {
            fieldName = "stock0" + segmentIdSeq;
        } else {
            fieldName = "stock" + segmentIdSeq;
        }

        try {

            Field field = ProductStock.class.getDeclaredField(fieldName);

            field.setAccessible(true);

            //  segment 库存
            Integer prodouctStockSeq = getFieldValueByFieldName(fieldName, productStockDb);

            field.set(productStock, prodouctStockSeq - bypPoductStock);

            //todo update
//            update(productStock);  更新库存


        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    /**
     * 根据segment  seq 获取此  segment 段库存
     *
     * @param productId
     * @param segmentId
     * @return
     */
    public Integer getProductStockBySegment(Integer productId, Integer segmentId) {
        //通过 sgementId 获取  fieldName

        ProductStock productStock = new ProductStock(12, 10, 10, 10, 10, 10, 10);
        if (productStock == null) {
            throw new ServiceException("商品不存在");
        }
        log.info("productStock:" + productStock);
        log.info("segmentId:" + segmentId);
        String fieldName = null;
        if (segmentId >= 1 && segmentId <= 9) {
            fieldName = "stock0" + segmentId;
        } else {
            fieldName = "stock" + segmentId;
        }

        return Integer.valueOf(getFieldValueByFieldName(fieldName, productStock));
    }


    private Integer getSegmentSeq(Integer stockSegment) {
        return (int) (Math.random() * stockSegment + 1);
    }


    /**
     * 根据属性名获取属性值
     *
     * @param fieldName
     * @param object
     * @return
     */
    private Integer getFieldValueByFieldName(String fieldName, Object object) {
        try {
            Field field = object.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            //设置对象的访问权限，保证对private的属性的访问

            return (Integer) field.get(object);
        } catch (Exception e) {

            return null;
        }
    }


}
