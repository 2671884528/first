package com.forkJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @auther 郭永钢
 * @data 2020/7/27 9:08
 * @desc:
 */

public class ForkJoinDemo extends RecursiveTask<Integer> {
    int start;
    int end;
    int result;

    final static int FLAG = 10;

    public ForkJoinDemo(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= FLAG) {
            for (int i = start; i <= end; i++) {
                result += i;
            }
        } else {
            int middle = start + (end - start) / 2;
            ForkJoinDemo task1 = new ForkJoinDemo(start, middle);
            ForkJoinDemo task2 = new ForkJoinDemo(middle + 1, end);

            task1.fork();
            task2.fork();

            result=task1.join()+task2.join();

        }
        return result;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinDemo forkJoinDemo = new ForkJoinDemo(1, 100);


        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Integer> submit = pool.submit(forkJoinDemo);
        System.out.println(submit.get());
        pool.shutdown();
    }
}
