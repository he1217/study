package com.he.study.designexample.create.factory.simple;

public class ChartFactory {
    /**
     *
     * @description
     * @author he.xuelong
     * @date 2020/3/16 14:16
     * @params [type]
     * @return com.he.example.ruleexample.create.factory.simple.Chart
     */
    public static Chart getChart(String type) { 
        Chart chart = null; 
        if ("histogram".equalsIgnoreCase(type)) {
            chart = new HistogramChart();
            System.out.println("初始化设置柱状图！");
        }else if ("pie".equalsIgnoreCase(type)) {
            chart = new PieChart();
            System.out.println("初始化设置饼状图！");
        }
        return chart;
    }
}
