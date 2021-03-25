package com.he.excise.newcode.important;

import com.he.study.designexample.action.strategy.main;

import java.util.Arrays;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2020/12/21 11:25
 */
public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        // low,high 为每次处理数组时的首、尾元素索引

        // 当low==high是表示该序列只有一个元素，不必排序了
        if (low >= high) {
            return;
        }
        // 选出哨兵元素和基准元素。这里左边的哨兵元素也是基准元素
        int i = low, j = high, base = arr[low];
        while (i < j) {
            // 右边哨兵从后向前找
            while (arr[j] >= base && i < j) {
                j--;
            }
            arr[i] = arr[j];
            // 左边哨兵从前向后找
            while (arr[i] <= base && i < j) {
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = base;
        // 递归调用，排序左子集合和右子集合
        quickSort(arr, low, j - 1);
        quickSort(arr, j + 1, high);

    }

//    private static void swap(int[] arr, int i, int j) {
//        int tmp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = tmp;
//    }

    public static void main(String[] args) {
        int[] ints = {3, 2, 1, 5, 2,6};
        quickSort(ints,0,5);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
