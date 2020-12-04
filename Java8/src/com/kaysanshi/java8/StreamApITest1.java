package com.kaysanshi.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @Author kay三石
 * @date:2020/5/2
 */
public class StreamApITest1 {
    List<Employee> list=new ArrayList<>();
    {
        list.add(new Employee("zhangsan",20,"郑州","30k"));
        list.add(new Employee("zhangsan2",30,"郑州","20k"));
        list.add(new Employee("zhangsan3",40,"郑州","40k"));
        list.add(new Employee("zhangsan4",50,"郑州","50k"));
        list.add(new Employee("zhangsan5",20,"郑州","30k"));
        list.add(new Employee("zhangsan6",20,"郑州","30k"));
    }
    // 1-筛选与切片
    @Test
    public  void test1(){
        // filter(Predicate p) 接收lambda，从流中排除某些元素
        list.stream().filter(e->e.getAge()>30).forEach(System.out::println);
        System.out.println("-------------");
        // limit(n) 截断流，使其元素不超过给定的数量
        System.out.println("-------------");

        list.stream().limit(3).forEach(System.out::println);
        // skip(n) 跳过元素，返回一个扔掉前n个元素的流，若流中元素不足n个则返回一个空串
        System.out.println("-------------");

        list.stream().skip(2).forEach(System.out::println);
        // distinct() -筛选，通过流所生成的元素的hashCode()和equals()方法去除重复原素
        System.out.println("-------------");

        list.stream().distinct().forEach(System.out::println);
    }

    /**
     * 映射
     *
     *
     *
     */
    @Test
    public void test2(){
        // map(Function f) 接收一个函数作为参数，将元素转换为其他形式或提取其他信息，该函数会被应用到每个元素上
        // 并将其映射成一个新的元素。
        List <String> list1 = Arrays.asList("aa", "bb", "cc", "dd", "ee");
        list1.stream().map(s -> s.toUpperCase()).forEach(System.out::println);

        list.stream().map(Employee::getName).forEach(System.out::print);
        list.stream().map(e->e.getName()).forEach(System.out::print);
        // flatMap(Function f) 接收一个函数作为参数，将流中每个值都换成另一流然后把所有流连接成一个流


    }
}
