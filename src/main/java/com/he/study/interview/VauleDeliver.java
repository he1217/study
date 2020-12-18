package com.he.study.interview;

import com.he.study.interview.entity.Student;

/**
 * 按值调用(call by value)表示方法接收的是调用者提供的值，
 * 而按引用调用（call by reference)表示方法接收的是调用者提供的变量地址。
 * 一个方法可以修改引用传递所对应的变量值，而不能修改值传递调用所对应的变量值
 *
 * @author he.xuelong
 * @Description 值传递面试点
 * @ClassName VauleDeliver
 * @Date 2020年05月20日 10:17
 */
public class VauleDeliver {

    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;
        String c = "hello ";
        swap(num1, num2,c);

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
        System.out.println("c= " +c);

        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println(arr[0]);
        change(arr);
        System.out.println(arr[0]);


        Student s1 = new Student("小张");
        Student s2 = new Student("小李");
        VauleDeliver.swap(s1, s2);
        System.out.println("张s1:" + s1.getName());
        System.out.println("李s2:" + s2.getName());


    }

    public static void swap(int a, int b,String c) {
        int temp = a;
        a = b;
        b = temp;
        c += "world";
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
    public static void change(int[] array) {
        // 将数组的第一个元素变为0
        array[0] = 0;
    }
    public static void swap(Student x, Student y) {
        Student temp = x;
        x = y;
        y = temp;
        System.out.println("x:" + x.getName());
        System.out.println("y:" + y.getName());
    }
}
