package com.he.excise.newcode.topn;

import java.util.LinkedList;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2021/9/21 15:21
 */
public class 从单向链表中删除指定值的节点 {
    public static void test(int[] a,int n){
        Integer[] test = new Integer[n*2];
        for (int i = 0; i < n*2; i++) {
            test[i] = a[i];
        }
        LinkedList<Integer> ret = new LinkedList<>();
        ret.add(test[0]);
        for (int i = 1; i < test.length-1; i+=2) {
            ret.add(ret.indexOf(test[i+1])+1,test[i]);
        }
        ret.remove(test[test.length-1]);
        for (int i :ret) {
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        int[] a = {2, 1 ,2 ,3 ,2 ,5 ,1 ,4 ,5, 7, 2,2};
        test(a,6);
//        Integer[] ints = new Integer[6*2];
//        for (int i = 0; i < 6 * 2; i++) {
//            ints[i] = a[i];
//        }
//        LinkedList<Integer> list = new LinkedList<>();
//        //头节点
//        list.add(ints[0]);
//        //依次插入
//        for (int i = 1; i < ints.length - 1; i += 2) {
//            int te = list.indexOf(ints[i + 1]);
//            list.add(list.indexOf(ints[i + 1]) + 1, ints[i]);
//        }
//        //删除最后出现的
//        list.remove(ints[ints.length - 1]);
//        for (Integer i : list) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
    }

}
