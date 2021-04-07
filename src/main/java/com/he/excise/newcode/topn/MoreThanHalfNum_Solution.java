package com.he.excise.newcode.topn;

import java.util.Arrays;
import java.util.function.IntPredicate;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2021/4/1 17:33
 */
public class MoreThanHalfNum_Solution {

    public static int moreThanHalfNum_Solution(int [] array) {
        int num = 0 ;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (count==0){
                num = array[i];
                count++;
            }else {
                if (num == array[i]){
                    count++;
                }else {
                    count--;
                }
            }
        }
        int j = 0;
        for (int i : array){
            if (i==num){
                j++;
            }
        }
        if (2*j>array.length){
            return num;
        }else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] input = {1,2,3,2,2,2,5,4,2};
        System.out.println(moreThanHalfNum_Solution(input));
    }
}

