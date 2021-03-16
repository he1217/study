package com.he.excise.newcode.topn;

import java.util.Arrays;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2021/3/15 17:02
 */
public class 最长递增子序列 {
        // write code here
        public static int[] LIS (int[] arr) {
            // write code here
            if(arr.length <= 1|| arr == null) return arr;
            // 序列
            int[] end = new int[arr.length];
            // 最长子序列的长度len
            int[] indlen = new int[arr.length];
            end[0] = arr[0];
            // 序列的长度
            int len = 1;
            indlen[0] = len;
            for(int i=1; i<arr.length; i++){
                if(end[(len-1)] < arr[i]){
                    // 如果大于就放在end后
                    end[len++] = arr[i];
                    indlen[i] = len;
                }else if(end[len-1] == arr[i]){
                    indlen[i] = len;
                }else{
                    // 替换第一个大于元素位置
                    int index = findFirstIndex(end, len, arr[i]);
                    end[index] = arr[i];
                    indlen[i] = (index+1);
                }
            }

            int[] res = new int[len];
            for(int i=arr.length-1; i>=0; i--){
                if(indlen[i] == len){
                    res[--len] = arr[i];
                }
            }
            return res;
        }

        public static int findFirstIndex(int[] end, int len, int key){
            int left = 0;
            int right = len - 1;
            while (left <= right) {
                int mid = (left + right) >> 1;
                if (end[mid] < key) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            //return end[left]<key ? (left+1):left;
            return left;
        }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(LIS(new int[]{3, 2, 5, 8,1, 6, 7})));
    }
}
