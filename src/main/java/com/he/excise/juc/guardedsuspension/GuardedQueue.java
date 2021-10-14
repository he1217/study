package com.he.excise.juc.guardedsuspension;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2021/7/15 19:21
 */
public class GuardedQueue {
    private final Queue<Integer> sourceList;

    public GuardedQueue() {
        this.sourceList = new LinkedBlockingQueue<>();
    }

    public synchronized Integer get() {
        while (sourceList.isEmpty()) {
            try {
                wait();    // <--- 如果队列为null，等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return sourceList.peek();
    }

    public synchronized void put(Integer e) {
        sourceList.add(e);
        notifyAll();  //<--- 通知，继续执行
    }
}
