package com.baidu.algorithm.leetcode;

import java.util.HashMap;

/**
 *  题目：直线上最多的点
 *
 *  思路：一个点加上一个斜率可以唯一确定一条直线
 *
 *  所以，可以对点进行分类，将问题转换为：经过某个点的直线，哪条直线上的点最多。
 *
 *  斜率相同的点在同一条直线上，用map存key
 *
 *  两个问题:
 *  1)斜率小数怎么办？
 *       用分数表示。求分子分母的最大公约数，约分；最后将"分子 + @ + 分母"作为key。
 *
 *  2)重复点怎么算？
 *       重复点会出现除0的情况。因此，需要用一个变量记录重复点的个数，重复点一定是过当前点的直线的。
 */
public class Code_149_maxPoints {

    public int maxPoints(int[][] points) {
        if (points.length < 3) {
            return points.length;
        }
        int res = 0;
        // 遍历每个点
        for (int i = 0; i < points.length; i++) {
            int duplicate = 0;
            int max = 0; // 保存经过当前点的直线中最多的点

            HashMap<String, Integer> map = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                // 求分子
                int x = points[j][0] - points[i][0];
                // 求分母
                int y = points[j][1] - points[i][1];

                if (x == 0 && y == 0) {
                    duplicate++;
                    continue;
                }

                //进行约分
                int gcd = gcd(x, y);
                x = x / gcd;
                y = y / gcd;
                String key = x + "@" + y;
                map.put(key, map.getOrDefault(key, 0) + 1);
                max = Math.max(max, map.get(key));

            }
            // 1表示当前考虑的点，duplicate代表和当前点重复的点
            res = Math.max(res, max + duplicate + 1);
        }
        return res;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
