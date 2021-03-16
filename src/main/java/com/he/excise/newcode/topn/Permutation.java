package com.he.excise.newcode.topn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2021/3/11 19:34
 */
public class Permutation {

    private ArrayList<String> res = new ArrayList<>();
    private TreeSet<String> paths = new TreeSet<>();
    private StringBuilder path = new StringBuilder();
    private boolean[] visited;

    public ArrayList<String> Permutation(String str) {
        if (str == null || str.equals("")) {
            return res;
        }
        char[] strs = str.toCharArray();
        Arrays.sort(strs);
        visited = new boolean[strs.length];
        combination(strs, 0);
        res.addAll(paths);
        return res;
    }

    private void combination(char[] strs, int len) {
        if (len == strs.length) {
            paths.add(path.toString());
            return;
        }
        for (int i = 0; i < strs.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                path.append(strs[i]);
                combination(strs, len + 1);
                //Duang ~ 回溯 - 状态重置
                visited[i] = false;
                path.deleteCharAt(path.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Permutation permutation= new Permutation();
        Solution solution = new Solution();
//        System.out.println(solution.Permutation("abc"));
    }

    public static class Solution {
        ArrayList<String> ret = new ArrayList<>();
        public ArrayList<String> Permutation(String str) {
            char[] chars = str.toCharArray();
            gogogo(chars, 0, chars.length-1);
            Collections.sort(ret);
            return ret;
        }
        public void gogogo(char[] str, int start, int end){
            if(end==start){
                String ans = String.valueOf(str);
                if(!ret.contains(ans)){
                    ret.add(ans);
                }
            }
            else{
                for(int i=start; i<=end; i++){
                    swap(str, start, i);
                    gogogo(str, start+1, end);
                    swap(str, start, i);
                }
            }

        }
        public void swap(char[] str, int left, int right){
            char tmp = str[left];
            str[left] = str[right];
            str[right] = tmp;
        }
    }
}
