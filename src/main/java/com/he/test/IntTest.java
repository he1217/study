package com.he.test;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2020/12/14 17:55
 */
public class IntTest {
    static List<Map> list = new ArrayList<>();
    static double b = 1.0d;


    public static void main(String[] args) {
        String s = "2c3f424a03abf8150cb202238774f89c";
        String s1 = "1d15be75cb5916a150902611950d97f9";
        List<Integer> a = new ArrayList<>();
        a.add(1);
       
    }
    @Test
    public  void test(){
        int[] a = {1,2,5,3};
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
    @Test
    public void testQuick(int[] arr , int low,int high){
        if (low>=high){
            return;
        }
        int i = low ,j = high ,base = arr[low];
        while(low<high){
            while (arr[j]>base && i<j){
                j--;
            }
            arr[i] = arr[j];
            while (arr[i]<base && i<j){
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = base;

        testQuick(arr,low,j-1);
        testQuick(arr,j+1,high);

    }
}
