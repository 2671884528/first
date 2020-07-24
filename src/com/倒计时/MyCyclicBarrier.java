package com.倒计时;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @auther 郭永钢
 * @data 2020/7/21 17:54
 * @desc: 顺计时
 */

public class MyCyclicBarrier {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("开始");
        });

        for (int i = 0; i < 7; i++) {
            new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName());
                    //等待七次
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },"线程"+i+"准备").start();
        }
    }
}
