package com.倒计时;

import java.util.concurrent.CountDownLatch;

/**
 * @auther 郭永钢
 * @data 2020/7/21 17:36
 * @desc:
 */

public class MyCountLauth {
    public static void main(String[] args) throws InterruptedException {
        /*计数*/
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "出门");
                countDownLatch.countDown();
            },"线程："+i).start();
        }
        //阻塞
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"关门");
    }
}
