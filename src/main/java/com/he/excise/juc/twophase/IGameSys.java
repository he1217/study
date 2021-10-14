package com.he.excise.juc.twophase;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2021/7/20 19:00
 */
public abstract class IGameSys {
    private long time;
    private String name;

    public IGameSys(long time, String name) {
        this.time = time;
        this.name = name;
    }


    public String name() {
        return this.name;
    }

    public long time() {
        return this.time;
    }

    public abstract void event(Object... ob) throws ThreadOverException;

    public abstract void overEvent();

}
