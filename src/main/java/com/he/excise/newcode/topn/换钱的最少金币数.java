package com.he.excise.newcode.topn;

import java.util.Arrays;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2021/5/8 18:14
 */
public class 换钱的最少金币数 {
    public int minMoney (int[] arr, int aim) {
        // 二维数组 dp[m][n], m 表示货币种类, n表示剩余找零
        int[][] dp = new int[arr.length][aim + 1];
        // 初始化第一种面值，若能被剩余找零整除，就在数组中填该货币使用的张数。
        for (int i = 1; i < aim + 1; ++i) {
            if (i % arr[0] == 0) {
                dp[0][i] = i / arr[0];
            }
        }
        Math
        for (int m = 1; m < arr.length; ++m) {
            for (int n = 1; n < aim + 1; ++n) {
                // 若当前面值大于剩余找零，则只能不使用此种货币
                if (arr[m] > n) {
                    dp[m][n] = dp[m - 1][n];
                } else if (arr[m] == n) {
                    dp[m][n] = 1;
                } else if (dp[m][n - arr[m]] != 0 &&  dp[m - 1][n] != 0) {
                    // 若使用一张当前货币和不使用当前货币都有值，取最小那个
                    dp[m][n] = min(dp[m][n - arr[m]] + 1, dp[m - 1][n]);
                } else {
                    // 若其中一个为 0，取不为 0 的那一个
                    dp[m][n] = dp[m][n - arr[m]] != 0 ? dp[m][n - arr[m]] + 1 : dp[m - 1][n];
                }

            }
        }
        return dp[arr.length-1][aim] == 0 ? -1 : dp[arr.length-1][aim];
    }

    private int min (int a, int b) {
        return a < b ? a : b;
    }

    public static int minMoney1 (int[] arr, int aim) {
        int[] count = new int[aim +1];
        Arrays.fill(count, aim + 1);
        //初始化数组
        count[0] = 0;
        for (int i =1;i<=aim;i++){
            for (int j = 0 ; j < arr.length ; j++){
                if (i >=arr[j]){
                    //当前的钱数-当前面值，为当前面值之前换过的钱数，如果能够兑换只需要在加+1即可，如果不能就取aim+1;
                    count[i] = Math.min(count[i-arr[j]] +1 , count[i]);
                }
            }
        }
        //对应的总数是否能够兑换取决于是否等于aim+1
        return count[aim] != aim+1 ? count[aim] :-1;
        // write code here
    }

    public static void main(String[] args) {
        minMoney1(new int[]{5,2,3},20);
    }
}

