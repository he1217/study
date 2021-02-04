package com.he.excise.newcode.topn;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author he.xl
 * @Description TODO
 * @ClassName
 * @Date 2020/12/28 17:44
 */
public class TwoStackBecameQuene {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack1.isEmpty()&&stack2.isEmpty()) return -1 ;
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

}
