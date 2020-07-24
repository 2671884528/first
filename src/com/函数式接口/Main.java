package com.函数式接口;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @auther 郭永钢
 * @data 2020/7/24 18:01
 * @desc:
 */

public class Main {
    public static void main(String[] args) {
//
//        //1.函数型接口,有输入和输出参数，类型Object
//        Function<String, Integer> function = new Function<String,Integer>() {
//            @Override
//            public Integer apply(String s) {
//                return s.length();
//            }
//        };
//        System.out.println(function.apply("我不爱你了"));
//        //2.断定行接口
//        Predicate<String> predicate = new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return s.isEmpty();
//            }
//        };
//        System.out.println(predicate.test("我不爱你了"));
//        //3.消费性接口
//        Consumer<String> consumer = new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s.length());
//            }
//        };
//        consumer.accept("我不爱你了");
//        //4.供给型接口
//        Supplier<String> supplier = new Supplier<String>() {
//            @Override
//            public String get() {
//                return "我不爱你了";
//            }
//        };
//        System.out.println(supplier.get());

        //简写
        Function<String, Integer> function = (s) -> {
            return s.length();
        };
        System.out.println(function.apply("我不爱你了"));

        Supplier<String> supplier = () -> "我不爱你了";
        System.out.println(supplier.get());

        Consumer<String> consumer = (s -> {
            System.out.println("我不爱你了");
        });
        consumer.accept("我不爱你了");

        Predicate<String> predicate = (s) -> s.isEmpty();
        System.out.println(predicate.test("我不爱你了"));
    }
}
