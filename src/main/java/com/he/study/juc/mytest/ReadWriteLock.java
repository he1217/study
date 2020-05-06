package com.he.study.juc.mytest;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLock {
    static java.util.concurrent.locks.ReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    AbstractQueuedSynchronizer abstractQueuedSynchronizer;
    ThreadLocal threadLocal;
    synchronized String  a(){
        return null;
    } ;
    public static void main(String[] args) {
        reentrantReadWriteLock.writeLock();
    }
}
