package com.he.study.designexample.create.factory.abstractfactory;
/**
 *  @Description SpringTextField.java spring文本框:具体产品
 *  @ClassName SpringTextField
 *  @author he.xuelong
 *  @Date 2020年03月16日 13:35
 * 
 */
public class SpringTextField implements TextField {
    /**
     *
     * @description
     * @author he.xuelong
     * @date 2020/3/16 13:35
     * @params []
     * @return void
     */
    @Override
    public void display() {
        System.out.println("显示绿色边框文本框。");
    }
}
