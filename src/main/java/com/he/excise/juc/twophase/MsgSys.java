package com.he.excise.juc.twophase;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2021/7/20 19:01
 */

public class MsgSys extends IGameSys {

    public MsgSys(long time, String name) {
        super(time, name);
    }
    private boolean temp=false;
    @Override
    public void event(Object... ob) throws ThreadOverException {
        if (!temp){
            System.out.println("<Thread-" + super.name() + ">[event]系统公告运行中 ><");
            temp=true;
        }
    }

    @Override
    public void overEvent() {
        System.out.println("<Thread" + super.name() + ">[overEvent]");
    }

}
