package com.阻塞队列;

import java.sql.SQLOutput;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/**
 * @auther 郭永钢
 * @data 2020/7/29 13:03
 * @desc:
 */

public class BlockQue {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue blockingQueue  =new ArrayBlockingQueue(5);
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        blockingQueue.put("d");
        blockingQueue.put("e");
//        blockingQueue.put("f");
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.size());
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.take());
    }
}
