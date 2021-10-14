package com.he.excise.juc.promise.example;

import com.he.excise.juc.promise.example.entity.BoilWater;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author he.xl
 * @Description TODO 抽象对象
 * @ClassName
 * @Date 2021/7/21 16:03
 */
public class Promisor {
    public  static Future<Object> create(long startTime) throws InterruptedException {
        System.out.println("开始烧水,当前用时"+(System.currentTimeMillis()-startTime)+"ms");
        //promise
        FutureTask<Object> future = new FutureTask<>(()->{
            BoilWater boilWater = new BoilWater();
            Thread.sleep(4500);
            boilWater.setState(true);
            return boilWater;
        });
        //Executor在这里执行
        new Thread(future).start();
        return future;
    }
}
