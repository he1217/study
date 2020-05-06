package com.he.study.designexample.action.strategy;

/**
 * @author he.xuelong
 * @ClassName Sum
 * @Description Sum
 * @Date 2020年02月28日 15:39
 */
public class Sum implements Strategy {
    /**
     * @return int
     * @description
     * @author he.xuelong
     * @date 2020/2/28 15:37
     * @params [a, b]
     */
    @Override
    public int handleNumber(int a, int b) {
        return a + b;
    }
}
