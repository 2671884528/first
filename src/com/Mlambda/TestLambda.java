package com.Mlambda;

/**
 * @auther 郭永钢
 * @data 2020/7/2 1:54
 * @desc: java8的新特性，lambda里面只能一个方法，可以有多个default（实现的方法）
 * 还可以加 static静态的实现方法
 * （参数）-> {处理}
 * @FunctionalInterface是隐士注解优化时，默认给你加上了
 */
@FunctionalInterface
interface Foo{
//    void sayHello();
    void add(int x,int y);
}

public class TestLambda {
    public static void main(String[] args) {
        Foo foo = (int a,int b) -> System.out.println(a+b);
        foo.add(10,11);
    }
}
