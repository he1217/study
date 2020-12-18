package com.he.study.designexample.structure.flyweight;

public class Demo {
    public static void main(String args[]) {

        String str1 = "abcd";

        String str2 = "abcd";

        String str3 = "ab" + "cd";

        String str4 = "ab";

        str4 += "cd";

        System.out.println(str1 == str2);

        System.out.println(str1 == str3);

        System.out.println(str1 == str4);
        System.out.println(str1.hashCode()+"    str4:"+str4.hashCode());

        str2 += "e";

        System.out.println(str1 == str2);

    }
}
