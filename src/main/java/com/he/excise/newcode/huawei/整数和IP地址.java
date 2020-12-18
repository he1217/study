package com.he.excise.newcode.huawei;
/**
 *  @Description 题目描述
 * 原理：ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成
 * 一个长整数。
 * 举例：一个ip地址为10.0.3.193
 * 每段数字             相对应的二进制数
 * 10                   00001010
 * 0                    00000000
 * 3                    00000011
 * 193                  11000001
 * 组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121，即该IP地址转换后的数字就是它了。
 * 的每段可以看成是一个0-255的整数，需要对IP地址进行校验
 * 输入描述:
 * 输入 
 * 1 输入IP地址
 * 2 输入10进制型的IP地址
 *
 * 输出描述:
 * 输出
 * 1 输出转换成10进制的IP地址
 * 2 输出转换后的IP地址
 *  @ClassName 整数和IP地址
 *  @author he.xuelong
 *  @Date 2020年05月29日 16:41
 * 
 */
public class 整数和IP地址 {
    public static void main(String[] args) {
        String ip = "1862271937";
        if (ip.indexOf(".")>0){
            String[] ip_num = ip.split("\\.");
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < ip_num.length; i++) {
                String s = Integer.toBinaryString(Integer.valueOf(ip_num[i]));
                String full = addZero(s, 8);
                sb.append(full);
            }
            System.out.println(Integer.valueOf(sb.toString(), 2));
        }else {
            System.out.println(toIP(ip));
        }

    }

    public static String toIP(String s) {
        String num = Integer.toBinaryString(Integer.valueOf(s));
        StringBuffer sb = new StringBuffer();
        if (num.length()<32) {
            String full = addZero(num, 32);
            for (int i = 0; i < full.length(); i = i + 8) {
                sb.append(Integer.valueOf(full.substring(i, i + 8), 2) + ".");
            }
            sb.delete(sb.length() - 1, sb.length());
        }else {
            for (int i = 0; i < num.length(); i = i + 8) {
                sb.append(Integer.valueOf(num.substring(i, i + 8), 2) + ".");
            }
        }
        return sb.toString();
    }



    public static String addZero(String s,int a){
        StringBuffer sb = new StringBuffer();
        if (s.length()<a){
            for (int i = 0; i < a - s.length(); i++) {
                sb.append("0");
            }
        }
        sb.append(s);
        return  sb.toString();
    }
}
