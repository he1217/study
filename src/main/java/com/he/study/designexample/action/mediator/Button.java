package com.he.study.designexample.action.mediator;

/**
 * @author he.xuelong
 * @Description 按钮类：具体同事类
 * @ClassName Button
 * @Date 2020年03月25日 12:36
 */
public class Button extends Component {
    @Override
    public void update() {
        //按钮不产生交互
    }

}

//列表框类：具体同事类
class List extends Component {
    @Override
    public void update() {
        System.out.println("列表框增加一项：张无忌。");
    }

    public void select() {
        System.out.println("列表框选中项：小龙女。");
    }

}

//组合框类：具体同事类
class ComboBox extends Component {
    @Override
    public void update() {
        System.out.println("组合框增加一项：张无忌。");
    }

    public void select() {
        System.out.println("组合框选中项：小龙女。");
    }
}

//文本框类：具体同事类
class TextBox extends Component {
    @Override
    public void update() {
        System.out.println("客户信息增加成功后文本框清空。");
    }

    public void setText() {
        System.out.println("文本框显示：小龙女。");
    }
}