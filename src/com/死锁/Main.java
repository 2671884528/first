package com.死锁;

/**
 * @auther 郭永钢
 * @data 2020/7/30 16:32
 * @desc: 死锁
 */
class Deadlock implements Runnable{
    String lockA;
    String lockB;

    public Deadlock(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName() + ":" + lockA + "以用");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName() + ":" + lockB + "请求调用");

            }
        }

    }
}
public class Main {

    public static void main(String[] args) {

        new Thread(
            new Deadlock("lockA","lockB")
        , "AAAA").start();
        new Thread(
            new Deadlock("lockB","lockA"),
         "BBBB").start();
    }

}
