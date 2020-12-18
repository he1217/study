package com.he.excise.newcode.huawei;
/**
 *  @Description 题目描述
 * 题目说明
 *
 * 蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。
 *
 * 样例输入
 * 5
 * 样例输出
 *
 * 1 3 6 10 15
 *
 * 2 5 9 14
 *
 * 4 8 13
 *
 * 7 12
 *
 * 11
 *  @ClassName 蛇形矩阵
 *  @author he.xuelong
 *  @Date 2020年06月01日 9:44
 * 
 */
public class 蛇形矩阵 {
    public static void main(String[] args) {
        int total = 5 ;
        int b = 1;
        for (int i = 1; i <= total; i++) {
            System.out.print(b);
            int a = b;
            for (int j = i+1; j <= total; j++) {
                a +=j;
                System.out.print(" "+a);
            }
            System.out.println();
            b+=i;
        }
    }
}
