package com.he.study.java8;

import java.text.SimpleDateFormat;

public class test {
    private static final ThreadLocal<SimpleDateFormat> formatter = new
            ThreadLocal<SimpleDateFormat>() {

                protected SimpleDateFormat initialvalue() {
                    return new SimpleDateFormat("yyyyMMdd HHmm");
                }
            };

    public static void main(String[] args) {
        int a = 13;
//        System.out.println("abcdefghijklmnopqrstuvwxyz".toUpperCase());
        if (true) {
            System.out.println("11111111111");

        } else if (true) {
            System.out.println("2222222222222");

        } else {
            System.out.println("288888888");
        }
    }

}
