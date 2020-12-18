package com.he.excise.newcode.huawei;

import org.apache.kafka.common.protocol.types.Field;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;

/**
 *  @Description 题目描述
 * Catcher是MCA国的情报员，他工作时发现敌国会用一些对称的密码进行通信，比如像这些ABBA，ABA，A，123321，
 * 但是他们有时会在开始或结束时加入一些无关的字符以防止别国破解。比如进行下列变化 ABBA->12ABBA,ABA->ABAKK,123321->51233214　
 * 。因为截获的串太长了，而且存在多种可能的情况（abaaab可看作是aba,或baaab的加密形式），Cathcer的工作量实在是太大了，
 * 他只能向电脑高手求助，你能帮Catcher找出最长的有效密码串吗？
 *  @ClassName 字符串_密码截取
 *  @author he.xuelong
 *  @Date 2020年05月29日 13:08
 * 
 */
public class 字符串_密码截取 {

    private static String string;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while ((line = br.readLine()) != null) {
            int max = 1;
            char[] xx = line.toCharArray();
            int len = xx.length;
            if (len == 0) {
                System.out.println(0);
            } else {
                for (int i = 1; i < len - max / 2; i++) {
                    //当字符串为奇数时
                    int low = i - 1, high = i;
                    while (low >= 0 && high < len && xx[low] == xx[high]) {
                        low--;
                        high++;
                    }
                    if (high - low - 1 > max) {
                        max = high - low - 1;
                    }
                    //当字符串为偶数时
                    low = i - 1;
                    high = i + 1;
                    while (low >= 0 && high < len && xx[low] == xx[high]) {
                        low--;
                        high++;
                    }
                    if (high - low - 1 > max) {
                        max = high - low - 1;
                    }
                }
            }
            System.out.println(max);
        }

    }
}
