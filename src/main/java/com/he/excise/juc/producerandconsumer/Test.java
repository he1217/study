package com.he.excise.juc.producerandconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2021/7/21 17:33
 */
public class Test {
    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger();
        AtomicInteger j = new AtomicInteger();
        // 生产者线程池
        ExecutorService producerThreads = Executors.newFixedThreadPool(3);
        // 消费者线程池
        ExecutorService consumerThreads = Executors.newFixedThreadPool(2);
        // 任务队列，长度为10
        ArrayBlockingQueue<Task> taskQueue = new ArrayBlockingQueue<Task>(10);
        // 生产者提交任务
        producerThreads.submit(() -> {
            try {
                System.out.println("生产数量"+(i));
                taskQueue.put(new Task("任务"+i));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        // 消费者处理任务
        consumerThreads.submit(() -> {
            try {

                Task task = taskQueue.take();
                System.out.println(task.taskName+"消费数据"+(j));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
    static class Task {
        // 任务名称
        private String taskName;
        public Task(String taskName) {
            this.taskName = taskName;
        }
    }
}
