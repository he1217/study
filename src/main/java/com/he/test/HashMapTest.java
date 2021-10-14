package com.he.test;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2021/8/31 14:31
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String,String> test = new HashMap<>(16);
        test.put("123","test");
        AtomicInteger i = new AtomicInteger();
        i.incrementAndGet();
        ConcurrentHashMap ts = new ConcurrentHashMap(16);
    }
}
