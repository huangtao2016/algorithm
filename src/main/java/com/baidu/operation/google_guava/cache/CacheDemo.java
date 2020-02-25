package com.baidu.operation.google_guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import lombok.Data;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 *  google guava中关于缓存loadingcache的demo，供上手理解用
 *  源网址：https://www.cnblogs.com/chengxin1982/p/6427663.html
 */
public class CacheDemo {

    @Data
    public static class Student {
        public int id;
        public String name;
    }

    public static void main(String[] args) throws ExecutionException {
        // 缓存接口这里是LoadingCache，LoadingCache在缓存项不存在时可以自动加载缓存
        // CacheBuilder的构造函数是私有的，只能通过其静态方法newBuilder()来获得CacheBuilder的实例
        LoadingCache<Integer,Student> studentCache = CacheBuilder.newBuilder()
                //设置并发级别为8，并发级别是指可以同时写缓存的线程数
                .concurrencyLevel(8)
                // 设置写缓存后8秒钟过期
                .expireAfterWrite(8, TimeUnit.SECONDS)
                // 设置缓存容器的初始容量为2
                .initialCapacity(2)
                // 设置缓存最大容量为2，超过2之后就会按照LRU最近虽少使用算法来移除缓存项，便于测试
                .maximumSize(2)
                // 设置要统计缓存的命中率
                .recordStats()
                // 设置缓存的移除通知
                .removalListener(new RemovalListener<Object, Object>() {
                    @Override
                    public void onRemoval(RemovalNotification<Object, Object> removalNotification) {
                        System.out.println(
                                removalNotification.getKey() + " was removed, cause is " + removalNotification.getCause());

                    }
                })
                // build方法中可以指定CacheLoader，在缓存不存在时通过CacheLoader的实现自动加载缓存
               .build(new CacheLoader<Integer, Student>() {
                   @Override
                   public Student load(Integer key) throws Exception {
                       System.out.println("load student " + key);
                       Student student = new Student();
                       student.setId(key);
                       student.setName("name_" + key);
                       return student;
                   }
               });

        // 从缓存中得到数据，由于我们没有设置过缓存，所以需要通过CacheLoader加载缓存数据
        Student student = studentCache.get(0);
        System.out.println(student);
        System.out.println("cache stats:");
        // 最后打印缓存的命中率等 情况
        System.out.println(studentCache.stats().toString());
        System.out.println("——————————————————————————————————");
        student = studentCache.get(1);
        System.out.println(student);
        student = studentCache.get(2);
        System.out.println(student);
        student = studentCache.get(3);
        System.out.println(student);
    }
}