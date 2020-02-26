package com.baidu.algorithm.basic_class_01;

/**
 *  一道面试题：给定一个数组，假如有序，返回相邻值的最大差值。
 *  要求时间复杂度和空间复杂度为O(N)
 *  比如 3 1 6 2 2，排序后，1 2 2 3 6，相邻元素最大差值为3，返回之。
 *
 *  思路：这里考虑用桶排序去做。
 */
public class Code_11_MaxGap {

    public static int maxGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        // for循环确定数组中最大值和最小值
        for (int i = 0; i < len; i++) {
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }
        if (min == max) {
            return 0;
        }
        // 3个len + 1的数组，用来记录对应的每一个桶的信息
        boolean[] hasNum = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        // 该变量用来确定nums[i]属于哪一个桶
        // for循环确定每个桶的最大值、最小值和是否是空桶
        int bid = 0;
        for (int i = 0; i < len; i++) {
            bid = bucket(nums[i], len, min, max);
            min = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
            max = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
            hasNum[bid] = true;
        }
        // 最后计算相邻元素的最大值
        int res = 0;
        int lastMax = maxs[0];
        for (int i = 1; i < len; i++) {
            if (hasNum[i]) {
                res = Math.max(res, mins[i] - lastMax);
                maxs[i] = lastMax;
            }
        }
        return res;
    }

    public static int bucket(long num, long len, long min, long max) {
        return (int) ((num - min) * len / (max - min));
    }

    public static void main(String[] args) {
        int a = (int) 5.6;
        System.out.println(a);
    }
}
