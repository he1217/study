package com.he.excise.newcode.topn;

import java.util.Stack;

/**
 * @author he.xl
 * @Description TODO 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
 * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
 * @ClassName
 * @Date 2020/12/30 19:08
 */
public class IsValid {
    public boolean isValid (String s) {
        // write code here
        Stack<Character> stack = new Stack<Character>();
        for(char c:s.toCharArray()){
            if(c =='(')
                stack.push(')');
            else if(c =='[')
                stack.push(']');
            else if(c =='{')
                stack.push('}');
            else if(stack.empty()||stack.pop()!=c)
                return false;
        }
        return stack.empty();
    }
}
