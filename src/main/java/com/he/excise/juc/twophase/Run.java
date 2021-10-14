package com.he.excise.juc.twophase;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2021/7/20 19:04
 */
public class Run {
    static IGameSys[] igame = {
            new MsgSys(500,"公告系统"),
            new ActivitySys(200,"活动系统")
    };
    public static void main(String[] args) throws InterruptedException {
        System.out.println("游戏服务器已启动");
        startThreadGroup();
        Thread.sleep(4000);
        SystemState.getInstance().sendState();

    }
    private static void startThreadGroup() {
        Iterator<IGameSys> it = Arrays.asList(igame).iterator();
        while (it.hasNext()) {
            Thread thread = new Thread(new RepairModelImpl(it.next()));
            thread.start();
        }
    }
}
