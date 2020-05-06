package com.he.study.designexample.structure.flyweight;

public class Client {
    public static void main(String args[]) {
        IgoChessman black1, black2, black3, white1, white2;

        //通过享元工厂获取三颗黑子
        black1 = IgoChessmanFactory.getIgoChessman("b");
        black2 = IgoChessmanFactory.getIgoChessman("b");
        black3 = IgoChessmanFactory.getIgoChessman("b");
        System.out.println("判断两颗黑子是否相同：" + (black1 == black2));

        white1 = IgoChessmanFactory.getIgoChessman("w");
        white2 = IgoChessmanFactory.getIgoChessman("w");
        System.out.println("判断两颗白子是否相同：" + (white1 == white2));
        black1.display();
        black2.display();
        black3.display();
        white1.display();
        white2.display();
    }
}
