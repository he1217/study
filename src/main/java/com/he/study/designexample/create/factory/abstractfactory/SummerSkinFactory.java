package com.he.study.designexample.create.factory.abstractfactory;

import com.he.study.designexample.create.factory.abstractfactory.product.SummerButton;
import com.he.study.designexample.create.factory.abstractfactory.product.SummerTextField;

public class SummerSkinFactory implements SkinFactory{
    @Override
    public Button createButton() {
        return new SummerButton();
    }

    @Override
    public TextField createTextField() {
        return new SummerTextField();
    }
}
