package com.he.study.designexample.create.Singleton.Lazy;

public class LazySingletonDouble {
    private volatile static LazySingletonDouble instance = null;

    private LazySingletonDouble() {
    }

    public static LazySingletonDouble getInstance() {
        //第一重判断
        if (instance == null) {
            //锁定代码块 synchronized (LazySingleton.class)
            { //第二重判断
                if (instance == null) {
                    instance = new LazySingletonDouble();
                    //创建单例实例
                }
            }
        }
        return instance;
    }

}
