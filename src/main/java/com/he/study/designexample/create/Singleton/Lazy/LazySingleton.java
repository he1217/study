package com.he.study.designexample.create.Singleton.Lazy;

/**
 *  @Description LazySingleton.java 懒汉式单例模式,但是这种可能还会出现多个对象,需要双重检查锁定
 *  @ClassName LazySingleton
 *  @author he.xuelong
 *  @Date 2020年03月16日 15:36
 * 
 */
public class LazySingleton {

    private static LazySingleton instance = null;
    private LazySingleton() { }
    synchronized public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
