package com.he.study.designexample.create.Singleton.IoDH;
/**
 *  @Description Singleton.java IoDH实现单例
 *  @ClassName Singleton
 *  @author he.xuelong
 *  @Date 2020年03月16日 16:30
 * 
 */
public class Singleton {
    private Singleton() {
    }
/**
 *  @Description Singleton.java内部类
 *  @ClassName Singleton
 *  @author he.xuelong
 *  @Date 2020年03月16日 16:05
 * 
 */
    private static class HolderClass {
        private final static Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return HolderClass.INSTANCE;
    }

    public static void main(String[] args) {
        Singleton s1, s2;
        s1 = Singleton.getInstance();
        s2 = Singleton.getInstance();
        System.out.println(s1 == s2);
    }
}

