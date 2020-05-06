package com.he.study.designexample.create.factory.abstractfactory;
/**
 *  @Description SkinFactory.java 抽象工厂
 *  @ClassName SkinFactory
 *  @author he.xuelong
 *  @Date 2020年03月16日 13:39
 *
 */
public interface SkinFactory {
    /**
     *
     * @description 按钮工厂
     * @author he.xuelong
     * @date 2020/3/16 14:27
     * @params []
     * @return com.he.example.ruleexample.create.factory.abstractfactory.Button
     */
    Button createButton();
    TextField createTextField();
}
