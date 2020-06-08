package com.baidu.algorithm.utils;

import java.time.LocalDate;

/**
 *   获取今年的天数
 *   使用工具类
 */
public class GetYearDays {

    public static void main(String[] args) {

        int daysOfThisYear = LocalDate.now().lengthOfYear();
        System.out.println("今年的天数为：" + daysOfThisYear);
    }
}
