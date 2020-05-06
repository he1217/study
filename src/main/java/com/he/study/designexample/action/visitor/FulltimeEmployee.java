package com.he.study.designexample.action.visitor;
/**
 *  @Description 全职员工类：具体元素类
 *  @ClassName FulltimeEmployee
 *  @author he.xuelong
 *  @Date 2020年03月30日 16:44
 * 
 */
public class FulltimeEmployee implements Employee {
    private String name;
    private double weeklyWage;
    private int workTime;

    public FulltimeEmployee(String name, double weeklyWage, int workTime) {
        this.name = name;
        this.weeklyWage = weeklyWage;
        this.workTime = workTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeeklyWage(double weeklyWage) {
        this.weeklyWage = weeklyWage;
    }

    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }

    public String getName() {
        return (this.name);
    }

    public double getWeeklyWage() {
        return (this.weeklyWage);
    }

    public int getWorkTime() {
        return (this.workTime);
    }

    @Override
    public void accept(Department handler) {
        handler.visit(this); //调用访问者的访问方法
    }
}
