package com.倒计时;

import java.util.concurrent.Semaphore;

/**
 * @auther 郭永钢
 * @data 2020/7/21 18:08
 * @desc: 信号量控制
 */

public class MySemaphore {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                try {
                    //占用资源
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "抢占车位");
                    Thread.sleep(3000);
                    //释放资源
                    System.out.println(Thread.currentThread().getName()+"释放车位");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }, "线程" + i).start();
        }
    }
}
