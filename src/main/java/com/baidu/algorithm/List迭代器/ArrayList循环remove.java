package com.baidu.algorithm.List迭代器;

import java.util.ArrayList;
import java.util.List;

public class ArrayList循环remove {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        //#1
        for(Integer integer: list) {
            list.remove(integer);
        }
    }
}
