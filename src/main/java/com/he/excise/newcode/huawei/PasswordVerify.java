package com.he.excise.newcode.huawei;
/**
 *  @Description 题目描述
 * 密码要求:
 * 1.长度超过8位
 *
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 *
 * 3.不能有相同长度超2的子串重复
 *
 * 说明:长度超过2的子串
 *
 * 输入描述:
 * 一组或多组长度超过2的子符串。每组占一行
 *
 * 输出描述:
 * 如果符合要求输出：OK，否则输出NG
 * 示例1
 * 输入
 * 021Abc9000
 * 021Abc9Abc1
 * 021ABC9000
 * 021$bc9000
 * 输出
 * OK
 * NG
 * NG
 * OK
 *  @ClassName PasswordVerify
 *  @author he.xuelong
 *  @Date 2020年05月28日 10:15
 * 
 */
public class PasswordVerify {
    public static void main(String[] args) {
        String a = "021Abc9000";
        char[] characters = a.toCharArray();
        int[] zi = new int[4] ;
        if (characters.length<9){

        }
        for (int i = 0 ; i<characters.length;i++ ){
            if (characters[i]>='A'&&characters[i]<='Z'){
                zi[0] = 1;
            }
            else if (characters[i]>='a'&&characters[i]<='z'){
                zi[0] = 1;
            }
            else if (characters[i]>='0'&&characters[i]<='9'){
                zi[0] = 1;
            }
            else {
                zi[0] = 1;
            }
            if(zi[0]+zi[1]+zi[2]+zi[3]<3){
                System.out.println("NG");
            }else{
                System.out.println(isHasSubString(a));
            }
        }
    }

    private static String isHasSubString(String str) {
        for (int i = 0; i < str.length() -3; i++) {
            String str1=str.substring(i,i+3);
            String str2=str.substring(i+3, str.length());
            if(str2.contains(str1)){
                return "NG";
            }
        }
        return "OK";
    }
}
