package com.baidu.algorithm.basic_class_02;

import java.util.Stack;

/**
 * 实现一个特殊的栈，在栈的正常功能上，实现一个返回栈中最小元素的函数
 */
public class Code_02_GetMinStack {

    public static class MyStack {
        public Stack<Integer> stackData;
        public Stack<Integer> stackMin;

        public MyStack() {
            stackData = new Stack<>();
            stackMin = new Stack<>();
        }

        public void push(int newNum) {
            if (stackMin.isEmpty()) {
                stackMin.push(newNum);
            } else if (newNum < getMin()) {
                stackMin.push(newNum);
            } else {
                int newMin = stackMin.peek();
                stackMin.push(newMin);
            }
            stackData.push(newNum);
        }

        public int pop() {
            if (stackData.isEmpty()) {
                throw new RuntimeException("Stack is empty.");
            }
            stackMin.pop();
            return stackData.pop();
        }

        public int getMin() {
            if (stackMin.isEmpty()) {
                throw new RuntimeException("Stack is empty.");
            }
            return stackMin.peek();
        }

    }
}
