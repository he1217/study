package com.he.study.designexample.structure.flyweight;

/**
 * @author he.xuelong
 * @Description 围棋棋子类：抽象享元类
 * @ClassName IgoChessman
 * @Date 2020年03月20日 17:19
 */
abstract class IgoChessman {
    public abstract String getColor();

    public void display() {
        System.out.println("棋子颜色：" + this.getColor());
    }
}
