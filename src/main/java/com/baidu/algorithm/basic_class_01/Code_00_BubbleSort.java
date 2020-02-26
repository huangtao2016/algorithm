package com.baidu.algorithm.basic_class_01;

/**
 * 冒泡排序
 * 时间复杂度 O(N2), 空间复杂度 O(1)
 * 可以做到稳定性
 */
public class Code_00_BubbleSort {

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int end = arr.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {3,3,4,4,2,1};
        bubbleSort(arr);
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
