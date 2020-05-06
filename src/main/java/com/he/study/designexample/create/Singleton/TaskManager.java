package com.he.study.designexample.create.Singleton;
/**
 *  @Description TaskManager.java单例模式简单实现,这种实现也是会出现多个对象
 *  @ClassName TaskManager
 *  @author he.xuelong
 *  @Date 2020年03月16日 15:22
 * 
 */
public class TaskManager {

    private static TaskManager tm = null;
    private TaskManager() {}
    /**
     *
     * @description 初始化窗口
     * @author he.xuelong
     * @date 2020/3/16 15:22
     * @params []
     * @return void
     */
    public void displayProcesses() {}
    /**
     *
     * @description 显示进程
     * @author he.xuelong
     * @date 2020/3/16 15:22
     * @params []
     * @return void
     */
    public void displayServices() {}
    /**
     *
     * @description 显示服务
     * @author he.xuelong
     * @date 2020/3/16 15:23
     * @params []
     * @return com.he.example.ruleexample.create.Singleton.TaskManager
     */
    public static TaskManager getInstance() {
        if (tm == null) { tm = new TaskManager(); }
        return tm;
    }
}
