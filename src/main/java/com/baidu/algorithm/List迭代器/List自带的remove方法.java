package com.baidu.algorithm.List迭代器;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class List自带的remove方法 {

    /*
       List自带了remove(index)方法，但是该方法在使用时会出现一些问题：
       其下标会一直往前走，
       当有元素移除，后面的集体前移时，就恰好会有漏网之鱼，指针没有指向过它
       详细的解释可参见：
       https://blog.csdn.net/weixin_39800144/article/details/77915981
     */

    public static void main(String[] args) {
        List<String> all=  new ArrayList<String>() ;	//
        all.add("hello") ;
        all.add("_") ;
        all.add("_world") ;
        Iterator<String> iter = all.iterator() ;	// 为Iterator接口实例化
        for(int j = 0; j < all.size();j++){
            String str = all.get(j);
            if(str.contains("_")){
                all.remove(j);
                j--;
            }else{
                System.out.println(str) ;	// 输出内容
            }

        }
        System.out.println("删除之后的集合：" + all) ;
    }
}
