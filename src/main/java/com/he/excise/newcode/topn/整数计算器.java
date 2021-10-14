package com.he.excise.newcode.topn;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2021/4/7 17:28
 */
public class 整数计算器 {
    public static int solve(String s) {
        // write code here
        char[] chars = s.toCharArray();
        Stack<String> cal = new Stack<>();
        for (int i = 0; i < chars.length; i++) {

        }
        return 0;
    }

    public static void cal(Stack<String> stack) {
        int a = Integer.parseInt(stack.pop());
        int b = Integer.parseInt(stack.pop());
        stack.push(String.valueOf(a + b));
    }

    public static void main(String[] args) {
        String instance = "{\"time\": [\n" +
                "            \"04-14 10:20\",\n" +
                "            \"04-14 10:21\",\n" +
                "            \"04-14 10:22\",\n" +
                "            \"04-14 10:23\",\n" +
                "            \"04-14 10:24\"\n" +
                "        ],\n" +
                "        \"10.161.55.11\": {\n" +
                "            \"IOWrite\": [\n" +
                "                \"0\",\n" +
                "                \"0\",\n" +
                "                \"0\",\n" +
                "                \"0\",\n" +
                "                \"0\"\n" +
                "            ]\n" +
                "        }}";

        JSONObject a =  new JSONObject(instance);
        Map<String, Object> stringObjectMap = a.toMap();
        HashMap o = (HashMap)stringObjectMap.get("10.161.55.11");
        o.put("IOTime",o.get("IOWrite"));
        System.out.println("o = " + stringObjectMap);

    }
}
