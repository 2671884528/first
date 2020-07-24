package com._01八锁;

import java.util.concurrent.TimeUnit;

/**
 * @auther 郭永钢
 * @data 2020/7/4 1:33
 * @desc:
 * 1.锁的是当前对象，当前资源类，所有的方法，所有的同步方法sync，都锁了
 * 2.普通方法，不和锁相关，想掉就掉
 * 3.当对象有两个的时候，就各找个的，资源不相干（锁的是对象，对象不同，锁没意义）
 * 4.static synchronized,类锁，锁的是类，所有的对象都需要遵循（全局锁）
 * 
 */

class Phone{
    synchronized void sendMes() throws InterruptedException {
//        TimeUnit.SECONDS.sleep(2);//java的新特性
        System.out.println("#######################");
    }
    synchronized void sendEmil(){
        System.out.println("************************");
    }
    void sayhello(){
        System.out.println("hello");
    }

}
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        new Thread(() -> {phone.sendEmil();
        },"A").start();
        Thread.sleep(100);
        new Thread(()->{
            try {
                phone.sendMes();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"B").start();
        new Thread(() -> {phone.sayhello();
        },"C").start();
    }
}
