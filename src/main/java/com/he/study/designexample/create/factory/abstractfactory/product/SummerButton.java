package com.he.study.designexample.create.factory.abstractfactory.product;

import com.he.study.designexample.create.factory.abstractfactory.Button;

public class SummerButton implements Button {
    @Override
    public void display() {
        System.out.println("显示浅蓝色按钮");
    }
}
