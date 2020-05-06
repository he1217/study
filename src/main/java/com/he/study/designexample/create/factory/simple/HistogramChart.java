package com.he.study.designexample.create.factory.simple;

public class HistogramChart implements Chart {
    public HistogramChart() {
        System.out.println("创建柱状图！"); }

    @Override
    public void display() {
        System.out.println("显示柱状图！");
    }
}
