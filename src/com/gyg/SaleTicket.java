package com.gyg;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther 郭永钢
 * @data 2020/7/2 1:02
 * @desc: 买票，企业级 3个售票员 30张票
 * 高内聚低耦合，线程，操作，资源类
 */

class Ticket//实例变量，实例方法
{
    private int number = 30;

    Lock lock = new ReentrantLock();

    public void sale() {
        lock.lock();
        try {
            if (number>0){
                System.out.println(Thread.currentThread().getName()+"卖出第："+(number--)+"剩余："+number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class SaleTicket {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(() ->  {for (int i = 0; i < 40; i++)  ticket.sale();},"A");
        new Thread(() ->  {for (int i = 0; i < 40; i++)  ticket.sale();},"B");
        new Thread(() ->  {for (int i = 0; i < 40; i++)  ticket.sale();},"C");
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 40; i++) {
//                    ticket.sale();
//                }
//            }
//        },"A").start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 40; i++) {
//                    ticket.sale();
//                }
//            }
//        },"B").start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 40; i++) {
//                    ticket.sale();
//                }
//            }
//        },"C").start();
    }
}
