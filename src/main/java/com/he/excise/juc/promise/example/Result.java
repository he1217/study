package com.he.excise.juc.promise.example;

import com.he.excise.juc.promise.example.entity.BoilWater;
import com.he.excise.juc.promise.example.entity.TeaAndCup;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2021/7/21 16:04
 */
public class Result {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long startTime = System.currentTimeMillis();
        //获取Promise
        Future<Object> promise = Promisor.create(startTime);
        System.out.println("开始准备茶叶和茶杯,需要3分钟,当前用时"+(System.currentTimeMillis()-startTime)+"ms");
        TeaAndCup teaAndCup = new TeaAndCup();
        Thread.sleep(3000);
        teaAndCup.setStatus(true);
        System.out.println("准备茶叶和茶杯结束,当前用时"+(System.currentTimeMillis()-startTime)+"ms");
        if (!promise.isDone()){
            System.out.println("茶叶茶杯结束,等待烧水完成!");

        }

        BoilWater boilWater = (BoilWater) promise.get();
        System.out.println("获取烧水完成信号,当前用时"+(System.currentTimeMillis()-startTime)+"ms");
        System.out.println("准备工作结束,开始泡茶,");
        System.out.println("总共用时"+(System.currentTimeMillis()-startTime)+"ms");
    }
}
