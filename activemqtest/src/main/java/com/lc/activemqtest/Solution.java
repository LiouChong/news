package com.lc.activemqtest;

import java.util.List;
import java.util.Stack;

class Solution {
    public List<String> generateParenthesis(int n) {
        Stack<String> stack = new Stack();

    }

    public boolean ifCan(Stack<String> stack, String s1) {
        String nowString = stack.pop();
        if ("(".equals(nowString)) {
            if ("(".equals(s1)) {
                stack.push(nowString);
                stack.push(s1);
            }
        } else {
            if ()
        }
    }
}