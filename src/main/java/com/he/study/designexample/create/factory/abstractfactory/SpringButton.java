package com.he.study.designexample.create.factory.abstractfactory;

/**
 *  @ClassName SpringButton 具体产品
 *  @Description SpringButton
 *  @author he.xuelong
 *  @Date 2020年03月16日 13:30
 * 
 */
public class SpringButton implements Button {
   /**
    *
    * @description 显示
    * @author he.xuelong
    * @date 2020/3/16 13:32
    * @params []
    * @return void
    */
    @Override
    public void display() {
        System.out.println("显示浅绿色按钮");
    }

}
