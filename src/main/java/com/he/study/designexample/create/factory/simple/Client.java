package com.he.study.designexample.create.factory.simple;

public class Client {

    public static void main(String args[]) {
        Chart chart;
        chart = ChartFactory.getChart("histogram");
        //通过静态工厂方法创建产品
        chart.display();
    }
}
