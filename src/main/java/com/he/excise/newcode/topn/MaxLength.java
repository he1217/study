package com.he.excise.newcode.topn;

/**
 * @author he.xl
 * @Description TODO 给定一个数组arr，返回arr的最长无的重复子串的长度(无重复指的是所有数字都不相同)
 * @ClassName
 * @Date 2020/12/29 19:06
 */
public class MaxLength {

    public static int maxLength (int[] arr) {
        int[] last = new int[100000];
        int n = arr.length;

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = arr[i];
            start = Math.max(start, last[index]);
            res   = Math.max(res, i - start + 1);
            last[index] = i+1;
        }

        return res;
    }

    public static void main(String[] args) {
        maxLength(new int[]{2,3,4,5,3});
    }
}
