package com.he.study.interview;

import java.util.ArrayList;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        byte a = 127;
        byte b = 127;
        // error: cannot convert from int to byte
        System.out.println(b += a); // ok
    }
}
