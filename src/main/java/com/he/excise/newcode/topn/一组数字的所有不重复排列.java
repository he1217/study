package com.he.excise.newcode.topn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author he.xl
 * @Description TODO 给出一组数字，返回该组数字的所有排列
 * 例如：
 * [1,2,3]的所有排列如下
 * [1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2], [3,2,1].
 * @ClassName
 * @Date 2021/5/18 19:07
 */
public class 一组数字的所有不重复排列 {
    private ArrayList<ArrayList<Integer>> res;
    private boolean[] visited;

    public ArrayList<ArrayList<Integer>> permute(int[] nums) {

        res = new ArrayList<>();
        visited = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        backtrace(nums, list);

        return res;
    }

    private void backtrace(int[] nums, List<Integer> list) {

        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
        }

        for (int i = 0; i < nums.length; i++) {

            if (visited[i]) continue;

            visited[i] = true;
            list.add(nums[i]);

            backtrace(nums, list);

            visited[i] = false;
            list.remove(list.size() - 1);

        }
    }
}
