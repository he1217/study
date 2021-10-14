package com.he.excise.newcode.topn;

import java.nio.file.Files;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2021/4/8 18:01
 */
public class 进制转换 {

    private static char[] array = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            .toCharArray();
    public String solve (int M, int N) {
        // write code here
        StringBuilder result = new StringBuilder();
        // 模拟计算进制的过程
        while (M > 0) {
            result.insert(0, array[M % N]);
            M /= N;
        }
        return result.toString();

    }
}
