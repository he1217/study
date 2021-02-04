package com.he.excise.newcode.topn;

import java.util.HashMap;

/**
 * @author he.xl
 * @Description TODO 给出一个整数数组，请在数组中找出两个加起来等于目标值的数， 给出的函数twoSum 需要返回这两个数字的下标
 * @ClassName
 * @Date 2020/12/28 17:56
 */
public class TwoSum {
    public static int[] twoSum (int[] numbers, int target) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0; i < numbers.length; i++){
            if(map.containsKey(target - numbers[i])){
                return new int[]{map.get(target - numbers[i]) , i+1};
            }
            else{
                map.put(numbers[i] , i+1);
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[] a = twoSum(new int[]{3,4,1,2},6);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

    }
}
