package com.baidu.algorithm.leetcode;

/**
 *  String to Integer
 *  "   -42"  ->  -42
 *  "4193 with words"  ->  4193
 *  "words and 987"  ->  0
 *  "-91283472332"  ->  INT_MIN (−2^31)
 */
public class Code_8_AtoiStringToInteger {

    private boolean isValid(char c) {
        return c == '+' || c == '-';
    }

    private int getResult(String s, boolean isNegative) {
        if(s.equals("")) return 0;
        try{
            int x = Integer.parseInt(s);
            return isNegative ? x*-1 : x;
        } catch(NumberFormatException e) {
            return isNegative ? Integer.MIN_VALUE: Integer.MAX_VALUE;
        }
    }

    public int myAtoi(String str) {
        // 去除两边空字符
        String s = str.trim();
        if ("".equals(s)) {
            return 0;
        }
        int index = 0;
        boolean isNegative = false;
        // 标记正负，如果+/-开头，下标右移一位
        if (isValid(s.charAt(index))) {
            if (s.charAt(index) == '-') {
                isNegative = true;
            }
            index++;
        }
        // char拼成buffer
        StringBuilder buffer = new StringBuilder();
        for (int i = index; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                buffer.append(s.charAt(i));
                continue;
            }
            break;
        }
        return getResult(buffer.toString(), isNegative);
    }

    public static void main(String[] args) {
        String str = "words and 987";
        System.out.println(new Code_8_AtoiStringToInteger().myAtoi(str));
    }
}
