package com.he.study.designexample.action.strategy;

/**
 * @author he.xuelong
 * @ClassName Context
 * @Description Context
 * @Date 2020年02月28日 15:39
 */
public class Context {
    private Strategy strategy;

    public void setStrategy(Strategy strategy1) {
        this.strategy = strategy1;
    }

    public int handNumber(int a, int b) {
        return this.strategy.handleNumber(a, b);
    }
}
