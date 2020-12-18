package com.he.excise.newcode.huawei;

import java.util.Arrays;
/**
 *  @Description 题目描述
 * 按照指定规则对输入的字符串进行处理。
 *
 * 详细描述：
 *
 * 将输入的两个字符串合并。
 *
 * 对合并后的字符串进行排序，要求为：下标为奇数的字符和下标为偶数的字符分别从小到大排序。这里的下标意思是字符在字符串中的位置。
 *
 * 对排序后的字符串进行操作，如果字符为‘0’——‘9’或者‘A’——‘F’或者‘a’——‘f’，则对他们所代表的16进制的数进行BIT倒序的操作，并转换为相应的大写字符。如字符为‘4’，为0100b，则翻转后为0010b，也就是2。转换后的字符为‘2’； 如字符为‘7’，为0111b，则翻转后为1110b，也就是e。转换后的字符为大写‘E’。
 *
 * 举例：输入str1为"dec"，str2为"fab"，合并为“decfab”，分别对“dca”和“efb”进行排序，排序后为“abcedf”，转换后为“5D37BF”
 * 接口设计及说明：
 *
 * 功能:字符串处理
 *
 * 输入:两个字符串,需要异常处理
 *
 * 输出:合并处理后的字符串，具体要求参考文档
 *
         *输入描述:
         *输入两个字符串
         *
         *输出描述:
         *输出转化后的结果
         *
         *示例1
         *输入
         *dec fab
         *输出
         *5D37BF
 *  @ClassName 字符串合并
 *  @author he.xuelong
 *  @Date 2020年05月29日 10:01
 * 
 */
public class 字符串合并 {
    public static void main(String[] args) {
        String a = "dec";
        String b = "fab";
       String s = a + b;
        StringBuilder br1=new StringBuilder();
        StringBuilder br2=new StringBuilder();
        for(int i=0;i<s.length();i++) {
            if(i%2==0) {
                br1.append(s.charAt(i));
            }
            else {
                br2.append(s.charAt(i));
            }
        }
        char[] ch1=br1.toString().toCharArray();
        char[] ch2=br2.toString().toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        char[] ch=new char[ch1.length+ch2.length];
        for(int i=0;i<ch.length;i++) {
            if(i%2==0) {
                ch[i]=ch1[i/2];
            }
            else {
                ch[i]=ch2[i/2];
            }
        }
        char[] password = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','A','B','C','D','E','F'};
        char[] dictionary = {'0','8','4','C','2','A','6','E','1','9','5','D','3','B','7','F','5','D','3','B','7','F'};
        for(int i=0;i<ch.length;i++) {
            if((ch[i]>='0'&&ch[i]<='9')||(ch[i]>='a'&&ch[i]<='f')||(ch[i]>='A'&&ch[i]<='F')) {
                ch[i]=dictionary[String.valueOf(password).indexOf(ch[i])];
            }
        }
        System.out.println(ch);

    }
}
