package com.baidu.algorithm.basic_class_01;

/**
 * 荷兰国旗问题
 * 给定一个num，大于num的放左边，等于num的放中间，大于num的放数组右边
 */
public class Code_08_NetherlandsFlag {

    public static int[] partition(int[] arr, int L, int R, int num) {
        int less = L - 1;
        int more = R + 1;
        while (L < more) {
            if (arr[L] < num) {
               swap(arr, ++less, L);
            } else if (arr[L] > num) {
                swap(arr, --more, L);
            } else {
                L++;
            }
        }
        return new int[] {less + 1, more - 1};
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
