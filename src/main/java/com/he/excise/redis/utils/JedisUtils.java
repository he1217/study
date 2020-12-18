package com.he.excise.redis.utils;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.BinaryClient.*;

/**
 * @author he.xuelong
 * @Description Redis通用工具类
 * @ClassName JedisUtils
 * @Date 2020年05月08日 16:41
 */
@Component
public class JedisUtils {

    private JedisPool pool = null;
    private String ip = "192.168.42.111";
    private int port = 6379;
    private String auth = "12345678";

    /**
     * 
     * @description 传入ip和端口号构建redis 连接
     * @author he.xuelong
     * @date 2020/5/8 16:42
     * s []
     */
    public JedisUtils() {
        if (pool == null) {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(500);
            config.setMaxIdle(5);
            config.setMaxWaitMillis(100);
            config.setTestOnBorrow(true);
            pool = new JedisPool(config, this.ip, this.port, 100000, this.auth);
        }
    }

    /**
     * 通过key获取储存在redis中的value 并释放连
     *
     *  key
     *  成功返回value 失败返回null
     */
    public String get(String key) {
        Jedis jedis = null;
        String value = null;
        try {
            jedis = pool.getResource();
            value = jedis.get(key);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return value;
    }

    /**
     * 向redis存入key和value,并释放连接资 如果key已经存在 则覆
     *
     *  key
     *  value
     *  成功 返回OK 失败返回 0
     */
    public String set(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();//每次操作时向pool借用个jedis对象，用完即还?
            return jedis.set(key, value);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
            return "0";
        } finally {
            returnResource(pool, jedis);
        }
    }

    /**
     * 向redis存入序列化的key和value,并释放连接资 如果key已经存在 则覆
     *
     *  成功 返回OK 失败返回 0
     */
    public String setSerializer(byte[] keyBytes, byte[] valueBytes) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.set(keyBytes, valueBytes);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
            return "0";
        } finally {
            returnResource(pool, jedis);
        }
    }

    /**
     * 通过序列化key获取储存在redis中的序列化value 并释放连
     *
     *  key
     *  成功返回value 失败返回null
     */
    public byte[] getSerializer(byte[] key) {
        Jedis jedis = null;
        byte[] value = null;
        try {
            jedis = pool.getResource();
            value = jedis.get(key);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return value;
    }

    /**
     * 删除指定的key,也可以传入一个包含key的数
     *
     *  keys 个key 也可以使 string 数组
     *  返回删除成功的个
     */
    public Long del(String... keys) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.del(keys);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
            return 0L;
        } finally {
            returnResource(pool, jedis);
        }
    }

    /**
     * 通过key向指定的value值追加?
     *
     *  key
     *  str
     *  成功返回 添加后value的长 失败 返回 添加 value 的长 异常返回0L
     */
    public Long append(String key, String str) {
        Jedis jedis = null;
        Long res = null;
        try {
            jedis = pool.getResource();
            res = jedis.append(key, str);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
            return 0L;
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * 判断key是否存在
     *
     *  key
     *  true OR false
     */
    public Boolean exists(String key) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.exists(key);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
            return false;
        } finally {
            returnResource(pool, jedis);
        }
    }

    /**
     * 设置key value,如果key已经存在则返0,nx==> not exist
     *
     *  key
     *  value
     *  成功返回1 如果存在  发生异常 返回 0
     */
    public Long setnx(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.setnx(key, value);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
            return 0L;
        } finally {
            returnResource(pool, jedis);
        }
    }

    /**
     * 设置key value并制定这个键值的有效
     *
     *  key
     *  value
     *  seconds 单位:
     *  成功返回OK 失败和异常返回null
     */
    public String setex(String key, String value, int seconds) {
        Jedis jedis = null;
        String res = null;
        try {
            jedis = pool.getResource();
            res = jedis.setex(key, seconds, value);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * 通过key 和offset 从指定的位置始将原先value替换 下标0,offset表示从offset下标始替
     * 如果替换的字符串长度过小则会这样 example: value : bigsea@zto.cn str : abc 从下7始替 则结果为
     * RES : bigsea.abc.cn
     *
     *  key
     *  str
     *  offset 下标位置
     *  返回替换 value 的长
     */
    public Long setrange(String key, String str, int offset) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.setrange(key, offset, str);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
            return 0L;
        } finally {
            returnResource(pool, jedis);
        }
    }

    /**
     * 通过批量的key获取批量的value
     *
     *  keys string数组 也可以是个key
     *  成功返回value的集, 失败返回null的集 ,异常返回
     */
    public List<String> mget(String... keys) {
        Jedis jedis = null;
        List<String> values = null;
        try {
            jedis = pool.getResource();
            values = jedis.mget(keys);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return values;
    }

    /**
     * 批量的设置key:value,可以 example: obj.mset(new
     * String[]{"key2","value1","key2","value2"})
     *
     *  keysvalues
     *  成功返回OK 失败 异常 返回 null
     */
    public String mset(String... keysvalues) {
        Jedis jedis = null;
        String res = null;
        try {
            jedis = pool.getResource();
            res = jedis.mset(keysvalues);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * 删除多个字符串key 并释放连
     *
     *  key*
     *  成功返回value 失败返回null
     */
    public boolean mdel(List<String> keys) {
        Jedis jedis = null;
        boolean flag = false;
        try {
            jedis = pool.getResource();//从连接�用Jedis对象
            Pipeline pipe = jedis.pipelined();//获取jedis对象的pipeline对象
            for (String key : keys) {
                pipe.del(key); //将多个key放入pipe删除指令
            }
            pipe.sync(); //执行命令，完全此时pipeline对象的远程调
            flag = true;
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return flag;
    }

    /**
     * 批量的设置key:value,可以,如果key已经存在则会失败,操作会回 example: obj.msetnx(new
     * String[]{"key2","value1","key2","value2"})
     *
     *  keysvalues
     *  成功返回1 失败返回0
     */
    public Long msetnx(String... keysvalues) {
        Jedis jedis = null;
        Long res = 0L;
        try {
            jedis = pool.getResource();
            res = jedis.msetnx(keysvalues);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * 设置key的?,并返回一个旧
     *
     *  key
     *  value
     *  旧? 如果key不存 则返回null
     */
    public String getset(String key, String value) {
        Jedis jedis = null;
        String res = null;
        try {
            jedis = pool.getResource();
            res = jedis.getSet(key, value);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * 通过下标 和key 获取指定下标位置 value
     *
     *  key
     *  startOffset 始位 0  负数表示从右边开始截
     *  endOffset
     *  如果没有返回null
     */
    public String getrange(String key, int startOffset, int endOffset) {
        Jedis jedis = null;
        String res = null;
        try {
            jedis = pool.getResource();
            res = jedis.getrange(key, startOffset, endOffset);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * 通过key 对value进行加?+1操作,当value不是int类型时会返回错误,当key不存在是则value1
     *
     *  key
     *  加�后的结
     */
    public Long incr(String key) {
        Jedis jedis = null;
        Long res = null;
        try {
            jedis = pool.getResource();
            res = jedis.incr(key);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * 通过key给指定的value加?,如果key不存,则这是value为该
     *
     *  key
     *  integer
     * 
     */
    public Long incrBy(String key, Long integer) {
        Jedis jedis = null;
        Long res = null;
        try {
            jedis = pool.getResource();
            res = jedis.incrBy(key, integer);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * 对key的�做减减操作,如果key不存,则设置key-1
     *
     */
    public Long decr(String key) {
        Jedis jedis = null;
        Long res = null;
        try {
            jedis = pool.getResource();
            res = jedis.decr(key);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * 减去指定的?
     *
     */
    public Long decrBy(String key, Long integer) {
        Jedis jedis = null;
        Long res = null;
        try {
            jedis = pool.getResource();
            res = jedis.decrBy(key, integer);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * 通过key获取value值的长度
     *
     *  失败返回null
     */
    public Long serlen(String key) {
        Jedis jedis = null;
        Long res = null;
        try {
            jedis = pool.getResource();
            res = jedis.strlen(key);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * 通过key给field设置指定的?,如果key不存,则先创建
     *
     *  field 字段
     *  如果存在返回0 异常返回null
     */
    public Long hset(String key, String field, String value) {
        Jedis jedis = null;
        Long res = null;
        try {
            jedis = pool.getResource();
            res = jedis.hset(key, field, value);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * 通过key给field设置指定的?,如果key不存在则先创,如果field已经存在,返回0
     *
     */
    public Long hsetnx(String key, String field, String value) {
        Jedis jedis = null;
        Long res = null;
        try {
            jedis = pool.getResource();
            res = jedis.hsetnx(key, field, value);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * 通过key同时设置 hash的多个field
     *
     *  返回OK 异常返回null
     */
    public String hmset(String key, Map<String, String> hash) {
        Jedis jedis = null;
        String res = null;
        try {
            jedis = pool.getResource();
            res = jedis.hmset(key, hash);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * 通过key  field 获取指定 value
     *
     *  没有返回null
     */
    public String hget(String key, String field) {
        Jedis jedis = null;
        String res = null;
        try {
            jedis = pool.getResource();
            res = jedis.hget(key, field);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * 通过key  fields 获取指定的value 如果没有对应的value则返回null
     *
     *  fields 可以 个String 也可以是 String数组
     */
    public List<String> hmget(String key, String... fields) {
        Jedis jedis = null;
        List<String> res = null;
        try {
            jedis = pool.getResource();
            res = jedis.hmget(key, fields);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * 通过key给指定的field的value加上给定的?
     *
     */
    public Long hincrby(String key, String field, Long value) {
        Jedis jedis = null;
        Long res = null;
        try {
            jedis = pool.getResource();
            res = jedis.hincrBy(key, field, value);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * 通过key和field判断是否有指定的value存在
     *
     */
    public Boolean hexists(String key, String field) {
        Jedis jedis = null;
        Boolean res = false;
        try {
            jedis = pool.getResource();
            res = jedis.hexists(key, field);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * 通过key返回field的数
     *
     */
    public Long hlen(String key) {
        Jedis jedis = null;
        Long res = null;
        try {
            jedis = pool.getResource();
            res = jedis.hlen(key);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;

    }
/**
 *
 * @author he.xuelong
 * @date 2020/5/8 16:48
 *  java.util.Map<java.lang.String,java.lang.String>
 */
    public Map<String, String> hgetAll(String key) {
        Jedis jedis = null;
        Map<String, String> res = null;
        try {
            jedis = pool.getResource();
            res = jedis.hgetAll(key);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;

    }

    /**
     * 通过key 删除指定 field
     *
     *  fields 可以  field 也可以是 个数
     */
    public Long hdel(String key, String... fields) {
        Jedis jedis = null;
        Long res = null;
        try {
            jedis = pool.getResource();
            res = jedis.hdel(key, fields);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     *
     * @author he.xuelong
     * @date 2020/5/8 16:48
     * s [key, start, end] 建
     *  java.util.Set<java.lang.String>
     */
    public Set<String> zrange(String key, Long start, Long end) {
        Jedis jedis = null;
        Set<String> res = null;
        try {
            jedis = pool.getResource();
            res = jedis.zrange(key, start, end);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * 通过key返回有的field
     *
     */
    public Set<String> hkeys(String key) {
        Jedis jedis = null;
        Set<String> res = null;
        try {
            jedis = pool.getResource();
            res = jedis.hkeys(key);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * 通过key返回有和key有关的value
     *
     */
    public List<String> hvals(String key) {
        Jedis jedis = null;
        List<String> res = null;
        try {
            jedis = pool.getResource();
            res = jedis.hvals(key);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * 通过key获取有的field和value
     *
     */
    public Map<String, String> hgetall(String key) {
        Jedis jedis = null;
        Map<String, String> res = null;
        try {
            jedis = pool.getResource();
            res = jedis.hgetAll(key);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * <p>
     * 通过key向list头部添加字符
     * </p>
     *
     *  strs 可以使一个string 也可以使string数组
     *  返回list的value个数
     */
    public Long lpush(String key, String... strs) {
        Jedis jedis = null;
        Long res = null;
        try {
            jedis = pool.getResource();
            res = jedis.lpush(key, strs);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * <p>
     * 通过key向list尾部添加字符
     * </p>
     *
     *  key
     *  strs 可以使一个string 也可以使string数组
     *  返回list的value个数
     */
    public Long rpush(String key, String... strs) {
        Jedis jedis = null;
        Long res = null;
        try {
            jedis = pool.getResource();
            res = jedis.rpush(key, strs);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * <p>
     * 通过key在list指定的位置之前或者之 添加字符串元
     * </p>
     *
     *  where LIST_POSITION枚举类型
     *  pivot list里面的value
     *  value 添加的value
     */
    public Long linsert(String key, LIST_POSITION where, String pivot, String value) {
        Jedis jedis = null;
        Long res = null;
        try {
            jedis = pool.getResource();
            res = jedis.linsert(key, where, pivot, value);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * <p>
     * 通过key设置list指定下标位置的value
     * </p>
     * <p>
     * 如果下标超过list里面value的个数则报错
     * </p>
     *
     *  index 0
     *  成功返回OK
     */
    public String lset(String key, Long index, String value) {
        Jedis jedis = null;
        String res = null;
        try {
            jedis = pool.getResource();
            res = jedis.lset(key, index, value);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * <p>
     * 通过key从对应的list中删除指定的count  value相同的元
     * </p>
     *
     *  count 当count0时删除全
     *  返回被删除的个数
     */
    public Long lrem(String key, long count, String value) {
        Jedis jedis = null;
        Long res = null;
        try {
            jedis = pool.getResource();
            res = jedis.lrem(key, count, value);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * <p>
     * 通过key保留list中从strat下标始到end下标结束的value
     * </p>
     *
     *  成功返回OK
     */
    public String ltrim(String key, long start, long end) {
        Jedis jedis = null;
        String res = null;
        try {
            jedis = pool.getResource();
            res = jedis.ltrim(key, start, end);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * <p>
     * 通过key从list的头部删除一个value,并返回该value
     * </p>
     *
     * 
     */
    public String lpop(String key) {
        Jedis jedis = null;
        String res = null;
        try {
            jedis = pool.getResource();
            res = jedis.lpop(key);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * <p>
     * 通过key从list尾部删除个value,并返回该元素
     * </p>
     *
     *  key
     * 
     */
    public String rpop(String key) {
        Jedis jedis = null;
        String res = null;
        try {
            jedis = pool.getResource();
            res = jedis.rpop(key);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * <p>
     * 通过key从一个list的尾部删除一个value并添加到另一个list的头,并返回该value
     * </p>
     * <p>
     * 如果第一个list为空或�不存在则返回null
     * </p>
     *
     *  srckey
     *  dstkey
     * 
     */
    public String rpoplpush(String srckey, String dstkey) {
        Jedis jedis = null;
        String res = null;
        try {
            jedis = pool.getResource();
            res = jedis.rpoplpush(srckey, dstkey);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * <p>
     * 通过key获取list中指定下标位置的value
     * </p>
     *
     *  key
     *  index
     *  如果没有返回null
     */
    public String lindex(String key, long index) {
        Jedis jedis = null;
        String res = null;
        try {
            jedis = pool.getResource();
            res = jedis.lindex(key, index);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * <p>
     * 通过key返回list的长
     * </p>
     *
     *  key
     * 
     */
    public Long llen(String key) {
        Jedis jedis = null;
        Long res = null;
        try {
            jedis = pool.getResource();
            res = jedis.llen(key);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * <p>
     * 通过key获取list指定下标位置的value
     * </p>
     * <p>
     * 如果start  0 end  -1 则返回全部的list中的value
     * </p>
     *
     *  key
     *  start
     *  end
     * 
     */
    public List<String> lrange(String key, long start, long end) {
        Jedis jedis = null;
        List<String> res = null;
        try {
            jedis = pool.getResource();
            res = jedis.lrange(key, start, end);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * <p>
     * 通过key向指定的set中添加value
     * </p>
     *
     *  key
     *  members 可以是一个String 也可以是个String数组
     *  添加成功的个
     */
    public Long sadd(String key, String... members) {
        Jedis jedis = null;
        Long res = null;
        try {
            jedis = pool.getResource();
            res = jedis.sadd(key, members);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    public void expire(String key, int times) {
        Jedis jedis = null;

        try {
            jedis = pool.getResource();
            jedis.expire(key, times);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
    }

    /**
     * <p>
     * 通过key删除set中对应的value
     * </p>
     *
     *  key
     *  members 可以是一个String 也可以是个String数组
     *  删除的个
     */
    public Long srem(String key, String... members) {
        Jedis jedis = null;
        Long res = null;
        try {
            jedis = pool.getResource();
            res = jedis.srem(key, members);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * <p>
     * 通过key随机删除个set中的value并返回该
     * </p>
     *
     *  key
     * 
     */
    public String spop(String key) {
        Jedis jedis = null;
        String res = null;
        try {
            jedis = pool.getResource();
            res = jedis.spop(key);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * <p>
     * 通过key获取set中的差集
     * </p>
     * <p>
     * 以第个set为标
     * </p>
     *
     *  keys 可以使一个string 则返回set中所有的value 也可以是string数组
     * 
     */
    public Set<String> sdiff(String... keys) {
        Jedis jedis = null;
        Set<String> res = null;
        try {
            jedis = pool.getResource();
            res = jedis.sdiff(keys);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * <p>
     * 通过key获取set中的差集并存入到另一个key
     * </p>
     * <p>
     * 以第个set为标
     * </p>
     *
     *  dstkey 差集存入的key
     *  keys   可以使一个string 则返回set中所有的value 也可以是string数组
     * 
     */
    public Long sdiffstore(String dstkey, String... keys) {
        Jedis jedis = null;
        Long res = null;
        try {
            jedis = pool.getResource();
            res = jedis.sdiffstore(dstkey, keys);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * <p>
     * 通过key获取指定set中的交集
     * </p>
     *
     *  keys 可以使一个string 也可以是个string数组
     * 
     */
    public Set<String> sinter(String... keys) {
        Jedis jedis = null;
        Set<String> res = null;
        try {
            jedis = pool.getResource();
            res = jedis.sinter(keys);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * <p>
     * 通过key获取指定set中的交集 并将结果存入新的set
     * </p>
     *
     *  dstkey
     *  keys   可以使一个string 也可以是个string数组
     * 
     */
    public Long sinterstore(String dstkey, String... keys) {
        Jedis jedis = null;
        Long res = null;
        try {
            jedis = pool.getResource();
            res = jedis.sinterstore(dstkey, keys);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * <p>
     * 通过key返回有set的并
     * </p>
     *
     *  keys 可以使一个string 也可以是个string数组
     * 
     */
    public Set<String> sunion(String... keys) {
        Jedis jedis = null;
        Set<String> res = null;
        try {
            jedis = pool.getResource();
            res = jedis.sunion(keys);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * <p>
     * 通过key返回有set的并,并存入到新的set
     * </p>
     *
     *  dstkey
     *  keys   可以使一个string 也可以是个string数组
     * 
     */
    public Long sunionstore(String dstkey, String... keys) {
        Jedis jedis = null;
        Long res = null;
        try {
            jedis = pool.getResource();
            res = jedis.sunionstore(dstkey, keys);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * <p>
     * 通过key将set中的value移除并添加到第二个set
     * </p>
     *
     *  srckey 要移除的
     *  dstkey 添加
     *  member set中的value
     * 
     */
    public Long smove(String srckey, String dstkey, String member) {
        Jedis jedis = null;
        Long res = null;
        try {
            jedis = pool.getResource();
            res = jedis.smove(srckey, dstkey, member);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * <p>
     * 通过key获取set中value的个
     * </p>
     *
     *  key
     * 
     */
    public Long scard(String key) {
        Jedis jedis = null;
        Long res = null;
        try {
            jedis = pool.getResource();
            res = jedis.scard(key);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * <p>
     * 通过key判断value是否是set中的元素
     * </p>
     *
     *  key
     *  member
     * 
     */
    public Boolean sismember(String key, String member) {
        Jedis jedis = null;
        Boolean res = null;
        try {
            jedis = pool.getResource();
            res = jedis.sismember(key, member);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * <p>
     * 通过key获取set中随机的value,不删除元
     * </p>
     *
     *  key
     * 
     */
    public String srandmember(String key) {
        Jedis jedis = null;
        String res = null;
        try {
            jedis = pool.getResource();
            res = jedis.srandmember(key);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * <p>
     * 通过key获取set中所有的value
     * </p>
     *
     *  key
     * 
     */
    public Set<String> smembers(String key) {
        Jedis jedis = null;
        Set<String> res = null;
        try {
            jedis = pool.getResource();
            res = jedis.smembers(key);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * 通过key向zset中添加value,score,其中score就是用来排序 如果该value已经存在则根据score更新元素
     *
     *  key
     *  scoreMembers
     * 
     */
    public Long zadd(String key, Map<String, Double> scoreMembers) {
        Jedis jedis = null;
        Long res = null;
        try {
            jedis = pool.getResource();
            res = jedis.zadd(key, scoreMembers);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * 通过key向zset中添加value,score,其中score就是用来排序 如果该value已经存在则根据score更新元素
     *
     *  key
     *  score
     *  member
     * 
     */
    public Long zadd(String key, double score, String member) {
        Jedis jedis = null;
        Long res = null;
        try {
            jedis = pool.getResource();
            res = jedis.zadd(key, score, member);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * 通过key删除在zset中指定的value
     *
     *  key
     *  members 可以使一个string 也可以是个string数组
     * 
     */
    public Long zrem(String key, String... members) {
        Jedis jedis = null;
        Long res = null;
        try {
            jedis = pool.getResource();
            res = jedis.zrem(key, members);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * 通过key增加该zset中value的score的?
     *
     *  key
     *  score
     *  member
     * 
     */
    public Double zincrby(String key, double score, String member) {
        Jedis jedis = null;
        Double res = null;
        try {
            jedis = pool.getResource();
            res = jedis.zincrby(key, score, member);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    public long hincrBy(String key, String field, long value) {
        Jedis jedis = null;
        long res = 0l;
        try {
            jedis = pool.getResource();
            res = jedis.hincrBy(key, field, value);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * 通过key返回zset中value的排 下标从小到大排序
     *
     *  key
     *  member
     * 
     */
    public Long zrank(String key, String member) {
        Jedis jedis = null;
        Long res = null;
        try {
            jedis = pool.getResource();
            res = jedis.zrank(key, member);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * 通过key返回zset中value的排 下标从大到小排序
     *
     *  key
     *  member
     * 
     */
    public Long zrevrank(String key, String member) {
        Jedis jedis = null;
        Long res = null;
        try {
            jedis = pool.getResource();
            res = jedis.zrevrank(key, member);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * 通过key将获取score从start到end中zset的value socre从大到小排序 当start0 end-1时返回全
     *
     *  key
     *  start
     *  end
     * 
     */
    public Set<String> zrevrange(String key, long start, long end) {
        Jedis jedis = null;
        Set<String> res = null;
        try {
            jedis = pool.getResource();
            res = jedis.zrevrange(key, start, end);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * 通过key返回指定score内zset中的value
     *
     *  key
     *  max
     *  min
     * 
     */
    public Set<String> zrangebyscore(String key, String max, String min) {
        Jedis jedis = null;
        Set<String> res = null;
        try {
            jedis = pool.getResource();
            res = jedis.zrevrangeByScore(key, max, min);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * 通过key返回指定score内zset中的value
     *
     *  key
     *  max
     *  min
     * 
     */
    public Set<String> zrangeByScore(String key, double max, double min) {
        Jedis jedis = null;
        Set<String> res = null;
        try {
            jedis = pool.getResource();
            res = jedis.zrevrangeByScore(key, max, min);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * 返回指定区间内zset中value的数
     *
     *  key
     *  min
     *  max
     * 
     */
    public Long zcount(String key, String min, String max) {
        Jedis jedis = null;
        Long res = null;
        try {
            jedis = pool.getResource();
            res = jedis.zcount(key, min, max);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * 通过key返回zset中的value个数
     *
     *  key
     * 
     */
    public Long zcard(String key) {
        Jedis jedis = null;
        Long res = null;
        try {
            jedis = pool.getResource();
            res = jedis.zcard(key);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * 通过key获取zset中value的score
     *
     *  key
     *  member
     * 
     */
    public Double zscore(String key, String member) {
        Jedis jedis = null;
        Double res = null;
        try {
            jedis = pool.getResource();
            res = jedis.zscore(key, member);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * 通过key删除给定区间内的元素
     *
     *  key
     *  start
     *  end
     * 
     */
    public Long zremrangeByRank(String key, long start, long end) {
        Jedis jedis = null;
        Long res = null;
        try {
            jedis = pool.getResource();
            res = jedis.zremrangeByRank(key, start, end);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * 通过key删除指定score内的元素
     *
     *  key
     *  start
     *  end
     * 
     */
    public Long zremrangeByScore(String key, double start, double end) {
        Jedis jedis = null;
        Long res = null;
        try {
            jedis = pool.getResource();
            res = jedis.zremrangeByScore(key, start, end);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * 返回满足pattern表达式的有key keys(*) 返回有的key
     *
     *  pattern
     * 
     */
    public Set<String> keys(String pattern) {
        Jedis jedis = null;
        Set<String> res = null;
        try {
            jedis = pool.getResource();
            res = jedis.keys(pattern);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * 通过key判断值得类型
     */
    public String type(String key) {
        Jedis jedis = null;
        String res = null;
        try {
            jedis = pool.getResource();
            res = jedis.type(key);
        } catch (Exception e) {
            jedis.close();
            e.printStackTrace();
        } finally {
            returnResource(pool, jedis);
        }
        return res;
    }

    /**
     * 返还到连接池
     */
    private static void returnResource(JedisPool pool, Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }
}