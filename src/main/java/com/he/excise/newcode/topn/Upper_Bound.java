package com.he.excise.newcode.topn;

import com.he.study.interview.ArraysUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author he.xl
 * @Description TODO 重复数字的有序数组的二分查找
 *                 输出在数组中第一个大于等于查找值的位置，如果数组中不存在这样的数，则输出数组长度加一
 * @ClassName
 * @Date 2020/12/16 15:51
 */
public class Upper_Bound {
    static public int upper_bound_ (int n, int v, int[] a) {
        // write code here
        int start = 0;
        int end = n-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(a[mid]==v){
                if(mid==0||a[mid-1]!=v){
                    return mid+1;
                }
                end=mid-1;
            }else if(a[mid]>v){
                if(mid==0||a[mid-1]<v){
                    return mid+1;
                }
                end=mid-1;
            }else if(a[mid]<v){
                start=mid+1;
            }
        }
        return n+1;
    }


    public static void main(String[] args) {
        int[] input = {4,5,1,6,2,7,3,8};
        int k =10;
        ArrayList<Integer> ret = new ArrayList<Integer>();
        Arrays.sort(input);
        List<Integer> integerList ;
        if(k>input.length){
            k=input.length-1;
        }
        for(int i=0;i<k;i++){
            ret.add(input[i]);
        }
        System.out.println(ret);
    }
}
