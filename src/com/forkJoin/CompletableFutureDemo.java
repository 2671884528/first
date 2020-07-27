package com.forkJoin;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @auther 郭永钢
 * @data 2020/7/27 9:49
 * @desc: 异步调用
 */

public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //没有返回值
//        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
//            System.out.println("no return value");
//        });
//
//        future.get();

        //有返回值，等待完成
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            int a = 10/0;
            System.out.println("normal execute");
            return 1024;
        });

        future1.whenCompleteAsync((o,e)->{
            System.out.println("normal:"+o);
            System.out.println("exception:"+e);
        }).exceptionally((f)->{
            System.out.println(f);
            return 404;
        }).get();
    }
}
