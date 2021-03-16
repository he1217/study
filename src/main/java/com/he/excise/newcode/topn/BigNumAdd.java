package com.he.excise.newcode.topn;


/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2021/3/2 19:15
 */
public class BigNumAdd {
    public static String solve (String s, String t) {
        // write code here
        String max;
        String mn;
        if (s.length()>t.length()){
            max = s;
            mn = t;
        }else {
            max = t;
            mn = s;
        }
        char[] a = new StringBuilder(max).reverse().toString().toCharArray();
        char[] b = new StringBuilder(mn).reverse().toString().toCharArray();
        int len = Math.max(a.length, b.length)+1;
        int min = Math.min(a.length, b.length);
        char[] result =  new char[len+1];
        int flag = 0;
        for (int i = 0; i < len-1; i++) {
            int num = 0;
            if (i<min){
                num = a[i]-'0'+b[i]-'0';
            }else {
                num = a[i]-'0';
            }
            if (flag == 1){
                num++;
            }
            if(num>9){
                result[i] = (char)(num%10 + '0');
                flag=1;
                continue;
            }
            if (flag==1){
                result[i] = (char)(num + '0');
                flag=0;
                continue;
            }
            result[i] = (char)(num + '0');
            flag=0;
        }
        if (flag==1){
            result[len]='1';
        }
        return String.valueOf(result);
    }

    public static void main(String[] args) {
        System.out.println(solve("733064866","459309139"));
        System.out.println(733064866+459309139);
    }
}
