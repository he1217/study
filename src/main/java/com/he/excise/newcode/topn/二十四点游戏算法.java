package com.he.excise.newcode.topn;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2021/9/26 15:15
 */
public class 二十四点游戏算法 {
    public static void main(String[] args) throws IOException {

        InputStream in = new ByteArrayInputStream("7 2 1 10".getBytes(StandardCharsets.UTF_8));
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String str;
        while( (str=br.readLine()) != null){
            String[] strNum = str.split(" ");
            int[] nums = new int[4];
            nums[0] = Integer.parseInt(strNum[0]);
            nums[1] = Integer.parseInt(strNum[1]);
            nums[2] = Integer.parseInt(strNum[2]);
            nums[3] = Integer.parseInt(strNum[3]);


            // todo check if ==24?
            boolean flag24 = false;
            for(int i=0; i<4; i++){
                if( is24dfs(nums, 1<<i, nums[i])){
                    flag24=true;
                    break;
                }else{
                    flag24=false;
                }
            }
            System.out.println(flag24);

        }
    }

    // 判断是否24点。
    private static boolean is24dfs(int[] nums, int used, int val){
        if(val == 24){
            return true;
        }

        // why flag 7??? todo 7== 0000,0111.??
        if(used == 7){
            return false;
        }

        for(int i=0; i<4; i++){
            int tmp = 1<<i; // 1左移i位 tmp 标识可否访问
            if( (tmp&used) ==0){ //位与：
                tmp |= used;   // 位或 +赋值
                if( is24dfs(nums, tmp, val+nums[i]) ||
                        is24dfs(nums, tmp, val-nums[i]) ||
                        is24dfs(nums, tmp, val*nums[i]) ||
                        (nums[i]!=0 && val%nums[i] ==0 && is24dfs(nums, tmp, val/nums[i]))){
                    // why last one.todo ??
                    return true;
                }
            }

        }
        return false;
    }
}
