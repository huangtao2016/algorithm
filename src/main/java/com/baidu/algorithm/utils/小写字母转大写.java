package com.baidu.algorithm.utils;

public class 小写字母转大写 {
    public static void main(String[] args) {

        // 小写转大写
        char word = 'a';
        char upperWord = (char) (word & 95);
        System.out.println(upperWord);

        // 大写转大写
        char word2 = 'A';
        char upperWord2 = (char)(word2 & 95);
        System.out.println(upperWord2);
    }
}
