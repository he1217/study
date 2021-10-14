package com.he.excise.newcode.topn;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2021/4/25 17:02
 */
public class 最长公共子串 {
    public static String LCS (String s1, String s2) {
        // write code here
        int len1 = s1.length();
        int len2 = s2.length();
        if(len1 == 0 || len2 == 0)
            return "-1";
        int[][] dp = new int[len1+1][len2+1];
        for(int i = 0; i < len1+1; i++){
            for(int j = 0; j < len2+1; j++){
                //初始化行列第一个元素
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                    continue;
                }
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        //找出一个最长的公共子序列
        StringBuilder sb = new StringBuilder();
        int s1L = len1, s2L = len2;
        while(s1L != 0 && s2L != 0){
            if (s1.charAt(s1L-1) == s2.charAt(s2L-1)){
                sb.append(s1.charAt(s1L - 1));
                s1L--;
                s2L--;
            }else{
                if (dp[s1L-1][s2L] > dp[s1L][s2L-1]){
                    s1L--;
                }else{
                    s2L--;
                }
            }
        }
        if(sb.length() == 0)
            return "-1";
        return sb.reverse().toString();
    }

    public static void main(String[] args) {

        LCS("1A2C3D4B56","B1D23CA45B6A");
    }
}
