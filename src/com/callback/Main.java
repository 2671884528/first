package com.callback;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @auther 郭永钢
 * @data 2020/7/15 14:41
 * @desc: 创建线程的第三种方法，采用Callable
 */
class MyThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("insert into call method");
        return 8888;
    }
}

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread myThread = new MyThread();
        FutureTask runnable = new FutureTask<Integer>(myThread);
        //第一种调用
//        runnable.run();
//        System.out.println(runnable.get());
        //第二种调用
        new Thread(runnable).start();
        System.out.println(runnable.get());

    }

}
