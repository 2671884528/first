package com.线程池;

import java.util.concurrent.*;

/**
 * @auther 郭永钢
 * @data 2020/7/24 10:31
 * @desc: 线程池的执行顺序没有什么规律，谁做完，谁干
 */
public class MyThreadPoolExecutor {

    public static void main(String[] args) throws InterruptedException {
//        获取CPU的核数
//        Runtime.getRuntime().availableProcessors()
        /*手写线程池*/
        ExecutorService pool = new ThreadPoolExecutor(2,5,3L
                ,TimeUnit.SECONDS,new LinkedBlockingQueue<>(3)
                ,Executors.defaultThreadFactory(),new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 10; i++) {
            long j =i;
            pool.execute(new Thread(()->{
                System.out.println("线程"+Thread.currentThread().getName());
            }));
        }

    }

    void init () throws InterruptedException {
        //固定数量
        //ExecutorService pool = Executors.newFixedThreadPool(5);
        //单线程
        //ExecutorService pool = Executors.newSingleThreadExecutor();
        //可扩展
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            long j =i;
            pool.execute(new Thread(()->{
                System.out.println("线程"+Thread.currentThread().getName());
            }));
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
