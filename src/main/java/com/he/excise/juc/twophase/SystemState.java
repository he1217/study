package com.he.excise.juc.twophase;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2021/7/20 19:03
 */
public final class SystemState {
    /**
     * 饿汉单例
     */
    private static SystemState instance = new SystemState();

    private SystemState() {
    }

    public static SystemState getInstance() {
        return instance;
    }

    private volatile boolean state = false;

    public boolean isState() {
        return state;
    }

    /**
     * 发送状态
     * @author Allen
     * @date 2017年2月21日
     */
    public void sendState() {
        this.state = true;

    }

}
