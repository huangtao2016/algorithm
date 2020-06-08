package com.baidu.algorithm.leetcode;

import java.util.Stack;

public class Code_150_ReversePolishNotation {

    public static int longestValidParentheses(String s) {
        Stack<String> stack = new Stack<>();
        String[] str = s.split("");

        int len = 0, maxLen = 0;
        for (int i =0; i < str.length; i++) {
            if ("(".equals(str[i])) {
                stack.push(str[i]);
            }
            if (")".equals(str[i]) && !stack.empty()) {
                stack.pop();
                len += 2;
                maxLen = Math.max(maxLen, len);
            } else {
                len = 0;
            }
            if (!stack.empty() && "(".equals(stack.peek())) {
                len = 0;
            }
        }
        return maxLen;
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String s: tokens) {
            if ("+".equals(s)) {
                Integer b = stack.pop();
                stack.push(stack.pop() + b);
            } else if ("-".equals(s)) {
                Integer b = stack.pop();
                stack.push(stack.pop() - b);
            } else if ("*".equals(s)) {
                Integer b = stack.pop();
                stack.push(stack.pop() * b);
            } else if ("/".equals(s)) {
                Integer b = stack.pop();
                stack.push(stack.pop() / b);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
//        String[] tokens = new String[]{"4","13","5","/","+"};
//        System.out.println(evalRPN(tokens));
        String s = "(()(())(()";
        System.out.println(longestValidParentheses(s));
    }
}
