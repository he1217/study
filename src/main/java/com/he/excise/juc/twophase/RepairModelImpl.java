package com.he.excise.juc.twophase;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2021/7/20 19:02
 */

public class RepairModelImpl implements IRepairModel {

    private IGameSys ir;

    public RepairModelImpl(IGameSys ir) {
        this.ir = ir;
    }

    @Override
    public void run() {
        System.out.println(ir.name() + "已启动");
        try {
            while (true) {
                Thread.sleep(ir.time());
                if (SystemState.getInstance().isState()) {
                    break;
                }
                ir.event();
            }
        } catch (ThreadOverException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            ir.overEvent();
        }
        return;
    }
}
