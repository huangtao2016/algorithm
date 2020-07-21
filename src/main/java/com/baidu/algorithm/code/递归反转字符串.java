package com.baidu.algorithm.code;

/**
 *
 * 未处理的递归反转字符串
 */
public class 递归反转字符串 {

    private static String reverse(String originStr) {
        if(originStr == null || originStr.length() <= 1)
            return originStr;
        return reverse(originStr.substring(1)) + originStr.charAt(0);
    }

    private static String reverseString(String string) {

        if (string.length() == 0) {
            return string;
        } else {
            return reverseString(string.substring(1)) + string.substring(0,1);
        }

    }

    public static void main(String[] args) {

        String string = "123 46";
        System.out.print(reverseString(string));
    }
}
