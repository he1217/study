package com.he.study.designexample.create.factory.abstractfactory.product;

import com.he.study.designexample.create.factory.abstractfactory.TextField;

/**
 *  @Description SummerTextField.java 具体产品
 *  @ClassName SummerTextField
 *  @author he.xuelong
 *  @Date 2020年03月16日 13:37
 * 
 */
public class SummerTextField implements TextField {
    @Override
    public void display() {
        System.out.println("显示蓝色文本框");
    }
}
