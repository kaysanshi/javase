package com.kaysanshi.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author kay三石
 * @date:2020/5/2
 * 1.Stream强调数据的运算，与CPu有关
 *  集合是数据的存储，与内存打交道
 * 2.
 *  Stream自己不会存储元素
 *  Stream不会改变源对象，相反他会返回一个持有结果的新Stream
 *  Stream操作是延迟执行的，这意味着他们会等到需要结果的时候才执行
 * 3.Strem执行流程
 *  Stream实例化
 *  一洗了的中间操作
 *  终止操作
 * 4.说明
 *      中间操作链可以有多个
 *      只有执行终止操作，就执行中间操作，并产生结果。
 *
 *
 */
public class StramAPITest {
    List<Employee> list=new ArrayList <>();
    {
        list.add(new Employee("zhangsan",20,"郑州","30k"));
        list.add(new Employee("zhangsan2",30,"郑州","20k"));
        list.add(new Employee("zhangsan3",40,"郑州","40k"));
        list.add(new Employee("zhangsan4",50,"郑州","50k"));
        list.add(new Employee("zhangsan5",20,"郑州","30k"));
        list.add(new Employee("zhangsan6",20,"郑州","30k"));
    }
    // 创建Stream方式：1.通过集合
    @Test
    public void test1(){
        // default Stream<E> stream():返回一个顺序流
        Stream <Employee> stream = list.stream();
        System.out.print(stream.findFirst().get().toString());

        // default Stream<E> parallelStream():返回一个并行流
        Stream <Employee> employeeStream = list.parallelStream();

    }
    // 创建方式 2:通过数组
    @Test
    public void test2(){
        // 调用Arrays类的static<T> Stream<T> stream(T[] array);
        int[] array=new int[]{1,2,34,45,5};
        Stream <Employee> stream = list.stream();
        IntStream stream1 = Arrays.stream(array);
        Employee employee=new Employee();
        Employee employee1=new Employee();
        Employee[] employees= new Employee[]{employee,employee1};
        Stream <Employee> stream2 = Arrays.stream(employees);
    }
    // 创建方式 3:通过Stream的of()
    @Test
    public void test3(){
        Stream <Integer> integerStream = Stream.of(1, 2, 34, 5, 6, 67, 9);
    }
    // 创建方式 4 ：创建无限流
}
