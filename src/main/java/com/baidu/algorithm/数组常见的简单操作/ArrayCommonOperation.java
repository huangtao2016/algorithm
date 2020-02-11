package com.baidu.algorithm.数组常见的简单操作;

/**
 * 数组的一些简单常见操作
 */
public class ArrayCommonOperation {

    public static void arrayCommonOperation(int[] arr) {

        // 找出数组中最大的元素
        double max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }

        // 计算数组元素的平均值
        int N = arr.length;
        double sum = 0.0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
        }
        double average = sum / N;

        // 复制数组
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        // 颠倒数组元素的顺序
        for (int i = 0; i < N/2; i++) {
           int temp = arr[i];
           arr[i] = arr[N-1-i];
            arr[N-1-i] = temp;
        }
    }
}
