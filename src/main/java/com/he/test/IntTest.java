package com.he.test;

import java.math.BigDecimal;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2020/12/14 17:55
 */
public class IntTest {
    static double a = 0.0d;
    static double b = 1.0d;
    public static void main(String[] args) {
        System.out.println(new BigDecimal(b).divide(new BigDecimal(a)));
    }
}
