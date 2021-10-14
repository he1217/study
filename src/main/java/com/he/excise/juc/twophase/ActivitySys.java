package com.he.excise.juc.twophase;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2021/7/20 19:00
 */
public class ActivitySys extends IGameSys {

    public ActivitySys(long time, String name) {
        super(time, name);
    }

    private boolean temp = false;

    @Override
    public void event(Object... ob) throws ThreadOverException {
        if (!temp){
            System.out.println("<Thread-" + super.name() + ">[event]活动系统运行中 ><");
            temp=true;
        }
    }

    @Override
    public void overEvent() {
        System.out.println("<Thread" + super.name() + ">[overEvent]");
    }

}
