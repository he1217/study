package com.he.excise.newcode.topn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author he.xl
 * @Description TODO 给定一个 n * m 的矩阵 a，从左上角开始每次只能向右或者向下走，最后到达右下角的位置，
 *             路径上所有的数字累加起来就是路径和，输出所有的路径中最小的路径和。
 * @ClassName
 * @Date 2021/4/2 17:53
 */
public class MinPathSum {
    public static int minPathSum(int matrix[][], int i, int j) {
        // 如果(i,j)就是右下角的元素
        if (i == matrix.length - 1 && j == matrix[0].length - 1) {
            return matrix[i][j];
        }
        // 如果(i,j)在右边界上，只能向下走
        if (j == matrix[0].length - 1) {
            return matrix[i][j] + minPathSum(matrix, i + 1, j);
        }
        // 如果(i,j)在下边界上，只能向右走
        if (i == matrix.length - 1) {
            return matrix[i][j] + minPathSum(matrix, i, j + 1);
        }
        // 不是上述三种情况，那么(i,j)就有向下和向右两种决策，取决策结果最小的那个
        int left = minPathSum(matrix, i, j + 1);
        int down = minPathSum(matrix, i + 1, j);
        return matrix[i][j] + Math.min(left,down );
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = bf.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int m = Integer.parseInt(strs[1]);
        int[][] matrix = new int[n][m];
        for(int i = 0; i < n; i++){
            String[] strs2 = bf.readLine().split(" ");
            for(int j = 0; j < m; j++){
                matrix[i][j] = Integer.parseInt(strs2[j]);
            }
        }
        System.out.print(minPath(matrix));
    }
    public static int minPath(int[][] matrix){
        if(matrix.length==0 || matrix[0].length==0 || matrix==null){
            return 0;
        }
        int rows=matrix.length;
        int cols=matrix[0].length;
        int[][] dp=new int[rows][cols];
        dp[0][0]=matrix[0][0];
        for(int j=1;j<cols;j++){
            dp[0][j]=dp[0][j-1]+matrix[0][j];
        }
        for(int i=1;i<rows;i++){
            dp[i][0]=dp[i-1][0]+matrix[i][0];
        }
        for(int i=1;i<rows;i++){
            for(int j=1;j<cols;j++){
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+matrix[i][j];
            }
        }
        return dp[rows-1][cols-1];
    }
}
