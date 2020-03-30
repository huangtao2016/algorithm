package com.baidu.algorithm.leetcode;

import java.util.Stack;

public class Code_150_ReversePolishNotation {

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
        String[] tokens = new String[]{"4","13","5","/","+"};
        System.out.println(evalRPN(tokens));
    }
}
