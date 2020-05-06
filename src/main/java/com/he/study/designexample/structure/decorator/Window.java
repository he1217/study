package com.he.study.designexample.structure.decorator;
/**
 *  @Description 窗口类:具体构件类
 *  @ClassName Window
 *  @author he.xuelong
 *  @Date 2020年03月20日 9:53
 * 
 */
public class Window extends Component {
    @Override
    public void display() {
        System.out.println("显示窗体！");
    }
}
/**
 *  @Description 文本框类：具体构件类
 *  @ClassName TextBox
 *  @author he.xuelong
 *  @Date 2020年03月20日 9:54
 * 
 */
class TextBox extends Component {
    @Override
    public void display() {
        System.out.println("显示文本框！");
    }
}
/**
 *  @Description 列表框类：具体构件类
 *  @ClassName ListBox
 *  @author he.xuelong
 *  @Date 2020年03月20日 9:55
 * 
 */
class ListBox extends Component {
    @Override
    public void display() {
        System.out.println("显示列表框！");
    }
}