package com.kaysanshi.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @Author kay三石
 * @date:2020/2/26
 * java内置的4大核心的函数式接口
 *
 * 消费型接口 Comsumer<T>  void accept(T t)
 * 供给型接口 Supplier<T>  T get()
 * 函数型接口 Function<T>  R apply(T t)
 * 断定型接口 Predicate<T> boolean test(T t)
 */
public class LambdaTest2 {

    @Test
    public void test1(){

        // 以前的写法
        happyTime(500, new Consumer <Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.print("dddd"+aDouble);
            }
        });
        // 现在使用方式lambda形式
        happyTime(500,money->System.out.print("lambda:" +money));
    }

    // 消费型的接口
    public void happyTime(double money, Consumer<Double> consumer){
        consumer.accept(money);
    }

    @Test
    public void test2(){
        List<String> list=new ArrayList <>(Arrays.asList("北京","南京","天井"));
        // 普通方式
        List <String> list1 = filterString(list, new Predicate <String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(list1);
        // lambda表达式
        List <String> list2 = filterString(list, s -> s.contains("京"));
        System.out.println(list2);

    }
    // 断定型的
    // 根据给定的规则，过滤集合中的字符串，此规则由Predicate定义
    public List<String> filterString(List<String> list, Predicate<String> predicate){
        ArrayList <String> objects = new ArrayList <>();
        for (String s:list){
            if(predicate.test(s)){
                objects.add(s);
            }
        }
        return objects;
    }
}
