package com.he.excise.newcode.important;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName 异步任务测试
 * @Date 2020/12/31 13:59
 */
public class FutureTest {
    public static void main(String[] args) {
       /* //调用异步任务
        new AsynTask().task(new MyCallback() {
            //实现回调方法
            @Override
            public void callback(Object object) {
                System.out.println("异步回调处理：值 "+object);
            }
        });
        System.out.println("主线程等待异步输出");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println("main函数开始执行");
        ExecutorService executor = Executors.newSingleThreadExecutor();
            int finalI = 3;
            CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
                System.out.println("===task start===");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("===task finish===");
                return finalI;
            }, executor);
            future.thenAccept(System.out::println);

        System.out.println("main函数执行结束");
        executor.shutdown();

    }
}

interface MyCallback {


    /**
     * 定义处理回调方法
     *
     * @param object
     */

    void callback(Object object);

}

/**
 * 异步任务类
 *
 * @author YZQ
 */

class AsynTask {

    /**
     * 处理任务
     *
     * @param myCallback 处理完任务后的回调
     */
    public void task(final MyCallback myCallback) {

        Thread thread = new Thread(() -> {
            try {
                //线程睡眠3秒，模拟该线程执行时间过长，也就是上面说的【B口有东西塞住】
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //完成0到99的累加
            int sum = 0;
            for (int i = 0; i < 100; i++) {
                sum += i;
            }
            //将结果交给接口的实现类取处理
            myCallback.callback(sum);
        }
        );
        //启动线程
        thread.start();
    }

}
