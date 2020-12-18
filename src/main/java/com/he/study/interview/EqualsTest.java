package com.he.study.interview;

/**
 *  @Description ==号和equals比较
 *  @ClassName EqualsTest
 *  @author he.xuelong
 *  @Date 2020年05月20日 13:34
 * 
 */
public class EqualsTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        /**
         *
         */

        Integer aaa = new Integer(5);
        Integer bbb = new Integer(5);
        System.out.println("封装int数据类型=:"+(aaa == bbb));
        System.out.println("封装int数据类型equal:"+aaa.equals(bbb));


        int a = 10;
        int b = 10;
        System.out.println("基本数据类型int:"+ (a == b));
        /*
        -128到127为int基础类型范围的
        * */
        int c = 100;
        int d = 150;
        System.out.println("基本数据类型150int:"+ (c == d));

        String str1 = new String("justice");
        String str2 = new String("justice");
        System.out.println("对象String=号:"+(str1 == str2));

        System.out.println("对象String equal:"+str1.equals(str2));


        String str4 = "123";
        String str5 = "123";
        System.out.println("基本String equal:"+str4 == str5);
        System.out.println("基本String equal:"+str4.equals(str5));


        String str3= str1;
        System.out.println("对象String赋值 =:"+(str1 == str3));
        System.out.println("对象String赋值 equal:"+str1.equals(str3));




        String str6 = "abcd";

        String str7 = "abcd";

        String str8 = "ab" + "cd";


        String str9 = "ab";

        str9 += "cd";

        System.out.println(str6 == str7);

        System.out.println(str6 == str8);

        System.out.println(str6 == str9);
        System.out.println(str6 == str9.intern());


    }
}
