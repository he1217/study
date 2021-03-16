package com.he.excise.newcode.topn;

import java.util.Arrays;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName 给出一个转动过的有序数组，你事先不知道该数组转动了多少
 * (例如,0 1 2 4 5 6 7可能变为4 5 6 7 0 1 2).
 * 在数组中搜索给出的目标值，如果能在数组中找到，返回它的索引，否则返回-1。
 * @Date 2021/3/16 17:15
 */
public class 转动过的有序数组 {
    public static int search (int[] A, int target) {
        // write code here
        if (A.length==0){
            return -1;
        }
        int first = A[0];
        int high = A.length-1;
        int low = 0;
        while (low<=high){
            int mid = (low+high)/2;
            if (A[mid]==target){
                return mid;
            }
            if (A[mid] >= A[low]) {
                // 左侧有序(含A[mid])
                if (A[mid] > target && A[low] <= target)
                    high = mid - 1;
                else
                    low = mid + 1;
            } else {
                // 右侧有序(含A[mid])
                if (A[mid] < target && A[high] >= target)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[] {228,234,235,236,238,239,240,241,242,243,245,248,250,253,256,257,258,260,261,262,263,264,266,268,271,272,275,276,279,280,281,282,283,284,285,287,289,291,294,295,1,6,7,8,9,10,11,13,14,15,17,18,19,20,21,22,23,25,28,30,31,36,41,43,46,48,51,52,53,54,58,59,60,62,64,66,68,72,73,77,85,86,89,92,94,95,97,98,101,105,108,112,116,118,120,121,122,124,125,127,128,129,130,131,132,135,137,139,140,142,145,147,149,152,154,156,157,158,159,168,169,170,171,172,
                176,178,182,185,188,190,195,200,201,202,203,204,206,208,210,212,216,219,224,226},266));
    }
}
