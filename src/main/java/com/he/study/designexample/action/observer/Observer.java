package com.he.study.designexample.action.observer;
/**
 *  @Description 抽象观察类
 *  @ClassName Observer
 *  @author he.xuelong
 *  @Date 2020年03月26日 16:34
 * 
 */
public interface Observer {
    public String getName();

    public void setName(String name);

    public void help(); //声明支援盟友方法
    public void beAttacked(AllyControlCenter acc); //声明遭受攻击方法
}
