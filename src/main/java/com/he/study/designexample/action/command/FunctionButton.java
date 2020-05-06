package com.he.study.designexample.action.command;

/**
 * @author he.xuelong
 * @Description 功能键类：请求发送者
 * @ClassName FunctionButton
 * @Date 2020年03月23日 15:57
 */
public class FunctionButton {
    private String name; //功能键名称
    private Command command; //维持一个抽象命令对象的引用

    public FunctionButton(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    //为功能键注入命令
    public void setCommand(Command command) {
        this.command = command;
    }//发送请求的方法

    public void onClick() {
        System.out.print("点击功能键：");
        command.execute();
    }
}
