package com.he.study.designexample.create.factory.abstractfactory;

import com.he.study.designexample.create.factory.abstractfactory.product.SpringButton;
import com.he.study.designexample.create.factory.abstractfactory.product.SpringTextField;

public class SpringSkinFactory implements SkinFactory {
    @Override
    public Button createButton() {
        return new SpringButton();
    }

    @Override
    public TextField createTextField() {
        return new SpringTextField();
    }
}
