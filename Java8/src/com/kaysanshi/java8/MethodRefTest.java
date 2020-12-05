package com.kaysanshi.java8;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Author kay三石
 * @date:2020/5/2
 * 方法引用的使用要求：
 * 要求接口中的抽象方法的形参列表和返回值的与引用的方法形参列表和返回值类型相同
 */
public class MethodRefTest {
    // 可以分为以下三种情况
    //对象:: 非静态方法
    //类::静态方法
    // 类::非静态方法(以前不可以这这样)
    // Consumer中的void accept(T t)
    //PrintSteam中的 void println(T t)
    @Test
    public void test1() {
        Consumer <String> con1 = str -> System.out.println(str);
        con1.accept("北京");
        System.out.println("************************");
        PrintStream ps = System.out;
        Consumer <String> con2 = ps::println;
        con2.accept("AAA");
    }

    /**
     * Supplier 中的 T get();
     * Employee中的 String getName();
     */
    @Test
    public void test2() {
        Employee employee = new Employee();
        employee.setName("TOM");
        Supplier <String> supplier = () -> employee.getName();
        System.out.print(supplier.get());
        System.out.println("----------------");
        Supplier <String> supplier1 = employee::getName;
        System.out.print(supplier1.get());

    }

    /**
     * 情况二： 类::静态方法
     * Comparator 中的int compare(T t1,T t2);
     * Integer int compare();
     */
    @Test
    public void test3() {
        Comparator <Integer> comparator = (t1, t2) -> Integer.compare(t1, t2);
        System.out.println(comparator.compare(1, 2));

        Comparator <Integer> comparator1 = Integer::compare;
        System.out.println(comparator1.compare(12, 3));

    }

    /**
     * Function 中的R apply(T t1);
     * Math中的 Long round(Double d);
     */
    @Test
    public void test4() {
        Function <Double, Long> function1 = new Function <Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(12.3);
            }
        };
        Function <Double, Long> function = d -> Math.round(d);
        System.out.println(function.apply(12.2));
        Function <Double, Long> function2 = Math::round;
        System.out.println(function2.apply(12.8));
    }

    /**
     * 情况三： 类::实例方法
     * Comparator 中的int compare(T t1,T t2);
     * String int t1.compareTo(t2);
     */
    @Test
    public void test5() {
        Comparator<String> comparator= (t1,t2)->t1.compareTo(t2);
        System.out.println(comparator.compare("abc","abd"));

        Comparator<String> comparator1=String::compareTo;
        System.out.println(comparator1.compare("abcs","aaa"));

    }
    /**
     *BiPredicate 中的boolean test(T t1,T t2)
     * String boolean t1.equals(t2)
     */
    @Test
    public void test6(){
        BiPredicate<String,String> predicate=(s1,s2)->s1.equals(s2);
        System.out.println(predicate.test("abc","abd"));

        BiPredicate<String,String> predicate2=String::equals;
        System.out.println(predicate2.test("abc","abd"));
    }
    /**
     *Function中的R apply(T t)
     * Employee中的String getName()
     */
    @Test
    public void test7(){
        Employee employee=new Employee();
        employee.setName("Tom");
        Function<Employee,String> comparator= e->e.getName();
        System.out.println(comparator.apply(employee));

        Function<Employee,String> comparator2=Employee::getName;
        System.out.println(comparator2.apply(employee));

    }
}