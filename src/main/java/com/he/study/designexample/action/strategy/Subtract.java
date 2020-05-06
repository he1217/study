package com.he.study.designexample.action.strategy;

/**
 *  @ClassName Subtract
 *  @Description Subtract
 *  @author he.xuelong
 *  @Date 2020年03月12日 18:41
 * 
 */
public class Subtract implements Strategy {
    @Override
    public int handleNumber(int a, int b) {
        return a - b;
    }
}
