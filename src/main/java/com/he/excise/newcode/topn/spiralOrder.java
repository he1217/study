package com.he.excise.newcode.topn;

import java.util.ArrayList;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2021/3/5 14:42
 */
public class spiralOrder {
    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix.length==0){
            return null;
        }
        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        while( top < (matrix.length+1)/2 && left < (matrix[0].length+1)/2 ){
            //上面  左到右
            for(int i = left; i <= right; i++){
                res.add(matrix[top][i]);
            }

            //右边 上到下
            for(int i = top+1; i <= bottom; i++){
                res.add(matrix[i][right]);
            }

            //下面  右到左
            for(int i = right-1; top!=bottom && i>=left; i--){
                res.add(matrix[bottom][i]);
            }

            //左边 下到上
            for(int i = bottom-1; left!=right && i>=top+1; i--){
                res.add(matrix[i][left]);
            }
            ++top;
            --bottom;
            ++left;
            --right;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][] {{1,2,3},{4,5,6},{7,8,9}}));
    }
}
