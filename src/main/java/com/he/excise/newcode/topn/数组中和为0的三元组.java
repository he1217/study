package com.he.excise.newcode.topn;

import java.util.ArrayList;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2021/3/19 17:16
 */
public class 数组中和为0的三元组 {
    public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> rets = new ArrayList<>();
        if (num.length < 3) {
            return null;
        }

        int two = 1, three = 2;
        for (int i = 0; i < num.length - 2; i++) {

            if (i >= 0 && num[i] == num[i + 1]&&i<num.length - 3) {
                two = i+2;
                three = i+3;
                continue;
            }
            while (two < three) {
                if (num[i] + num[two] + num[three] == 0) {
                    ArrayList<Integer> ret = new ArrayList<>();
                    ret.add(num[i]);
                    ret.add(num[two]);
                    ret.add(num[three]);
                    if (!rets.contains(ret)){
                        rets.add(ret);
                    }
                }
                if (three < num.length - 1) {
                    three++;
                    continue;
                }
                if (three >= num.length - 1 && two < num.length - 2) {
                    two++;
                    three = two + 1;
                } else {
                    break;
                }
            }

        }
        return rets;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
