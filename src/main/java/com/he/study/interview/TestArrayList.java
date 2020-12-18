package com.he.study.interview;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.function.Consumer;

public class TestArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(-1);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(-5);
        arrayList.add(7);
        arrayList.add(4);
        arrayList.add(-9);
        arrayList.add(-7);
        //添加一个集合
        arrayList.addAll(arrayList);

        //复制
        System.out.println(arrayList.clone());
        //对函数的每个元素的操作 lamoda表达式
        arrayList.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {

            }
        });
        arrayList.forEach((Integer a) ->{

        });
        //自定义排序方式
        arrayList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
        arrayList.sort((Integer::compareTo));
        //确保容纳最小参数
        arrayList.ensureCapacity(8);
        ListIterator a =  arrayList.listIterator();
        System.out.println();
        System.out.println(a.nextIndex());
    }
}
