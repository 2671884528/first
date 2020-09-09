package com.阻塞队列;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @auther 郭永钢
 * @data 2020/7/29 13:31
 * @desc:
 */

public class SynchronousBlockQue {

    public static void main(String[] args) {

        BlockingQueue queue = new SynchronousQueue();

        new Thread(()->{
            try {
                queue.put("a");
                queue.put("b");
                queue.put("c");
                queue.put("d");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAAAA").start();
        new Thread(()->{
            try {
                System.out.println(queue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(queue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(queue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(queue.take());
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"BBBBB").start();
    }
}
