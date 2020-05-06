package com.he.study.designexample.action.command;
/**
 *  @Description 帮助命令类：具体命令类
 *  @ClassName HelpCommand
 *  @author he.xuelong
 *  @Date 2020年03月23日 16:11
 * 
 */
public class HelpCommand extends Command {
    private HelpHandler hhObj; //维持对请求接收者的引用

    public HelpCommand() {
        hhObj = new HelpHandler();
    }
    //命令执行方法，将调用请求接收者的业务方法
    @Override
    public void execute() {
        hhObj.display();
    }
}
