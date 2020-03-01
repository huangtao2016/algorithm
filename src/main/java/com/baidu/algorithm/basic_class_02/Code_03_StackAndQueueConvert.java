package com.baidu.algorithm.basic_class_02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 题1：队列结构实现一个栈
 * 题2：栈结构实现一个队列
 */
public class Code_03_StackAndQueueConvert {

    // 用两个队列实现栈结构
    public static class TwoQueuesStack {
        private Queue<Integer> data;
        private Queue<Integer> help;

        public TwoQueuesStack() {
            data = new LinkedList<>();
            help = new LinkedList<>();
        }

        public void push(int pushInt) {
            data.add(pushInt);
        }

        public int pop() {
            if (data.isEmpty()) {
                throw new RuntimeException("Stack is empty.");
            }
            while (data.size() > 1) {
                help.add(data.poll());
            }
            int res = data.poll();
            swap();
            return res;
        }

        public int peek() {
            if (data.isEmpty()) {
                throw new RuntimeException("Stack is empty.");
            }
            while (data.size() > 1) {
                help.add(data.poll());
            }
            int res = data.poll();
            help.add(res);
            swap();
            return res;
        }

        private void swap() {
            Queue<Integer> tmp = help;
            help = data;
            data = tmp;
        }
    }

    // 用两个栈实现队列
    public static class TwoStacksQueue {
        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        public TwoStacksQueue() {
            stackPush = new Stack<>();
            stackPop = new Stack<>();
        }

        public void push(int pushInt) {
            stackPush.push(pushInt);
        }

        public int poll() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty.");
            } else if (stackPop.empty()) {
                while (!stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.pop();
        }

        public int peek() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty.");
            } else if (stackPop.empty()) {
                while (!stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.peek();
        }
    }
}
