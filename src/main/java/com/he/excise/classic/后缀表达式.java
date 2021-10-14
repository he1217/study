package com.he.excise.classic;

import java.util.Stack;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2021/4/7 17:42
 */
public class 后缀表达式 {
    static String houzhui(String Biaoda) {
        String number = "";
        Stack<String> fu = new Stack<String>();
        for (int i = 0; i < Biaoda.length(); i++) {
            String temp = String.valueOf(Biaoda.charAt(i));
            if (temp.equals("+") || temp.equals("-")) {
                while (!fu.isEmpty()) {
                    if (fu.peek().equals("(")) break;
                    number += fu.pop();
                }
                fu.push(temp);
            } else if (temp.equals("*") || temp.equals("/")) {
                while (!fu.isEmpty()) {
                    String aa = fu.peek();
                    if (aa.equals("(")) break;
                    if (aa.equals("+") || aa.equals("-")) break;
                    number += fu.pop();
                }
                fu.push(temp);
            } else if (temp.equals("(")) {
                //扫描到"("  直接入栈
                fu.push(temp);
            } else if (temp.equals(")")) {
                while (!fu.isEmpty()) {
                    String tempF = fu.pop();
                    if (tempF.equals("(")) break;
                    number += tempF;
                }
            } else {
                //扫描到操作数直接加入后缀表达式  即 加入操作数栈
                number += temp;
            }
        }
        //符号栈中依次出栈加入后缀表达式
        while (!fu.isEmpty()) number += fu.pop();
        return number;
    }

    static int solve(String temp, Stack<String> fu) {
        if (temp.equals("+")) {
            cal(fu, "+");
        } else if (temp.equals("-")) {
            cal(fu, "-");
        } else if (temp.equals("*")) {
            cal(fu, "*");
        } else if (temp.equals("/")) {
            cal(fu, "/");
        } else {
            fu.push(temp);
        }

        return Integer.parseInt(fu.peek());
    }

    public static void cal(Stack<String> stack, String cal) {
        int a = Integer.parseInt(stack.pop());
        int b = Integer.parseInt(stack.pop());
        if (cal.equals("+")) {
            stack.push(String.valueOf(a + b));
        } else if (cal.equals("-")) {
            stack.push(String.valueOf(b - a));
        } else if (cal.equals("*")) {
            stack.push(String.valueOf(a * b));
        } else if (cal.equals("/")) {
            stack.push(String.valueOf(b / a));
        }

    }

    public static void main(String[] args) {




    }
}
