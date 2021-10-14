package com.he.excise.newcode.topn;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2021/4/29 17:50
 */
public class 最小覆盖子串 {
    public String minWindowTest (String S, String T) {
        // write code here
        StringBuilder big =  new StringBuilder(S);
        StringBuilder small =  new StringBuilder(T);
        int d = S.length();
        for (int i = 0; i < small.length(); i++) {
            char a = small.charAt(i);
            int index = big.indexOf(String.valueOf(a));

        }

        return null;
    }

    public static void main(String[] args) {
        int[] map1 = new int[]{2,51,12,95,42,52,76,77,23,81,71,41,2,23,43,4,64,22,71,
                96,1,87,51,91,67,16,58,11,44,38,63,14,4,69,88,49,92,91,9,15,17,74,21,91,
                24,78,62,50,82,26,53,18,25,14,94,79,44,11,36,38,44,53,9,34,58,6,50,82,81,50,36,
                1,6,61,9,47,33,47,84,41,57,48,73,18};
        System.out.println(map1[82]);
    }

    public String minWindow (String S, String T) {
        int[] map = new int[128];


        OptionalInt max = Arrays.stream(map).max();
        for(int i = 0; i<T.length(); i++){
            map[T.charAt(i)]++;
        }
        int begin = 0, end =0, count = T.length(), d = Integer.MAX_VALUE, head = 0;
        while(end < S.length()){
            if(map[S.charAt(end++)]-- >0){
                count--;
            }
            while(count == 0){
                if((end - begin) < d){
                    head = begin;
                    d = end-begin;
                }
                if(map[S.charAt(begin++)]++ == 0){
                    count++;
                }
            }
        }
        return d == Integer.MAX_VALUE ? "" : S.substring(head, head+d);
    }

}
