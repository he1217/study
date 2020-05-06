package com.he.study.designexample.action.state;

/**
 * @author he.xuelong
 * @Description 抽象状态类
 * @ClassName AccountState
 * @Date 2020年03月30日 13:18
 */
abstract class AccountState {
    protected Account acc;

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);

    public abstract void computeInterest();

    public abstract void stateCheck();
}
