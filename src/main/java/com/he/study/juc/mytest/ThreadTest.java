package com.he.study.juc.mytest;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest implements Runnable {
    public CountDownLatch latch;
    public ForkJoinPool forkJoinPool;
    public ForkJoinTask forkJoinTask;
    public Lock lock = new ReentrantLock();
    public ThreadPoolExecutor threadPoolExecutor;


      ThreadTest(int latchNum){
        latch = new CountDownLatch(latchNum);
        threadPoolExecutor = new ThreadPoolExecutor(5,10,10000L,
                TimeUnit.SECONDS,new LinkedBlockingDeque<>(8),
                (Runnable r)->{
                    Thread t = new Thread(r, "my-thread-");
                    System.out.println(t.getName() + " has been created");
                    return t;

                },new ThreadPoolExecutor.DiscardOldestPolicy());
         /**
         四种策略
         AbortPolicy  抛出异常
         CallerRunsPolicy  用于被拒绝任务的处理程序，它直接在 execute 方法的调用线程中运行被拒绝的任务；如果执行程序已关闭，则会丢弃该任务
          DiscardOldestPolicy 抛弃最老的请求
          DiscardPolicy  用于被拒绝任务的处理程序，默认情况下它将丢弃被拒绝的任务。
          */
    }

    @Override
    public synchronized void run() {
    }
}
