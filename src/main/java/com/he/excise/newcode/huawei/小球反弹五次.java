package com.he.excise.newcode.huawei;

import static javafx.scene.input.KeyCode.L;

/**
 *  @Description 题目描述
 * 假设一个球从任意高度自由落下，每次落地后反跳回原高度的一半; 再落下, 求它在第5次落地时，共经历多少米?第5次反弹多高？
 *
 * 最后的误差判断是小数点6位
 *
 * 输入描述:
 * 输入起始高度，int型
 *
 * 输出描述:
 * 分别输出第5次落地时，共经过多少米第5次反弹多高
 *  @ClassName 小球反弹五次
 *  @author he.xuelong
 *  @Date 2020年06月01日 14:10
 * 
 */
public class 小球反弹五次 {
    public static void main(String[] args) {
        double high = 1L;
        double total = high;
        for (int i = 1; i < 5; i++) {
            total +=high;
            high= high/2;

        }
        high= high/2;
        System.out.println(total);
        System.out.println(high);
    }
}
