package com.baidu.algorithm.utils;

import java.util.LinkedList;
import java.util.List;

public class jdk8安全删除集合元素方法 {
    public static void main(String[] args) {

        List<String> words = new LinkedList<>();
        words.add("a");
        words.add("b");
        words.add("c");
        words.add("d");

        // JDK8推出的新接口
        words.removeIf(word -> word.equals("c"));

        words.forEach(System.out::println);

        // 增强型for循环 删除元素c
        for (String word : words) {
            if ("c".equals(word)) {
                words.remove(word);
            }
        }

        words.stream().forEach(System.out::println);
    }
}
