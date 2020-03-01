package com.baidu.algorithm.basic_class_01;

/**
 * 简单的题：用数组实现固定长度的栈和队列
 */
public class Code_12_ArrayStack_ArrayQueue {

    /**
     * 用数组实现栈：
     *    关键指针：index
     *    开始时,index = 0;
     *    push时,赋值 & index++;
     *    pop时,return arr[--index];
     *    peek时,直接return arr[index - 1]
     */
    public static class ArrayStack {
        public Integer[] arr;
        public Integer index; // index指定当前指针位置

        // init arr
        public ArrayStack(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The initSize is less than 0");
            }
            arr = new Integer[initSize];
            index = 0;
        }

        public Integer peek() {
            if (index == 0) {
                return null;
            }
            return arr[index - 1];
        }

        public void push(int obj) {
            if (index == arr.length) {
                throw new ArrayIndexOutOfBoundsException("The stack is full");
            }
            arr[index++] = obj;
        }

        public Integer pop() {
            if (index == 0) {
                throw new ArrayIndexOutOfBoundsException("The stack is empty");
            }
            return arr[--index];
        }
    }

    /**
     * 用数组实现队列：
     *    关键指针：size,start,end
     *    size:描述队列大小，push时size++;pop时，size--
     *    start:指向先进队列的元素
     *    end:指向进队列的元素的下一个位置
     *
     *    开始时，size = 0;start = 0;end = 0;
     *    push时，if size < arr.length, size++ & 赋值 & end++;
     *           如果end = arr.length - 1, end返回队列头部，即end = 0;
     *           否则，end++;
     *    poll时，size-- & return arr[start];
     *           如果start = arr.length - 1, start返回队列头部，即start = 0;
     *           否则，start++;
     *    peek时,return arr[start]即可
     */
    public static class ArrayQueue {
        private Integer[] arr;
        private Integer size;
        private Integer start;
        private Integer end;

        // init arr
        public ArrayQueue(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The initSize is less than 0");
            }
            arr = new Integer[initSize];
            size = 0;
            start = 0;
            end = 0;
        }

        public Integer peek() {
            if (size == 0) {
                return null;
            }
            return arr[start];
        }

        public void push(int obj) {
            if (size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("The queue is full");
            }
            size++;
            arr[end] = obj;
            end = end == arr.length - 1 ? 0 : end + 1;
        }

        public Integer poll() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("The queue is empty");
            }
            size--;
            int tmp = start;
            start = start == arr.length - 1 ? 0 : start + 1;
            return arr[tmp];
        }
    }
}
