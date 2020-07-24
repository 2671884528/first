package com.MList;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @auther 郭永钢
 * @data 2020/7/3 1:18
 * @desc: 出现异常：java.util.ConcurrentModificationException
 * 解决方法：
 * 1.Vector<Object> list = new Vector<>();
 * 自带的Vector，加了synchronized
 * 2. List<Object> list = Collections.singletonList(new ArrayList<>());
 * list继承自Collection，可以使用Collections来加锁
 * 3. List list = new CopyOnWriteArrayList();
 * CopyOnWriteArrayList()实现了List，
 * HashSet 底层HashMap,但是add（）方法只传一个值，因为底层，
 * 已经创建一个对象，每一add，就把你传的对象和底层的一个对象
 * 组合成map.add(obj,obj)
 */

public class MArrayList {
    public static void main(String[] args) {
        testList();
        HashSet<Object> hashSet = new HashSet<>();
//        ConcurrentHashMap hashMap = new ConcurrentHashMap();
        hashSet.add(1);
    }

    private static void testList() {
        //        ArrayList<Object> list = new ArrayList<>();
//        Vector<Object> list = new Vector<>();
//        List<Object> list = Collections.singletonList(new ArrayList<>());
        List list = new CopyOnWriteArrayList();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
