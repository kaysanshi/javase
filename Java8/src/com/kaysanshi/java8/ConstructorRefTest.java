package com.kaysanshi.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Author kay三石
 * @date:2020/5/2
 *
 *
 * 构造器引用
 *      和方法引用类似，函数式接口的抽象方法形参列表和构造器形参方法一致，
 *      抽象方法返回值即为构造器所属类型。
 * 数组引用
 *
 */
public class ConstructorRefTest {

    //Supplier 中的T get()
    @Test
    public void test1(){
        Supplier<Employee> supplierOld= new Supplier <Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };
        Supplier<Employee> supplier=()->new Employee();
        supplier.get();
        Supplier<Employee> supplier2=Employee::new;
        System.out.println(":"+supplier2.get());;
    }
    //Function 中的R apply(T t)
    @Test
    public void test2(){
        Function<String,Employee> function =name->new Employee(name);
        Employee employee=function.apply("TOME");
        System.out.print(employee);
        //
        Function<String,Employee> function2 =Employee::new;
        Employee employee1=function2.apply("TOME");
        System.out.print(employee1);
    }
    @Test
    public void test3(){
//        BiFunction<String,String,Employee> function=(id,name)->new Employee(id,name);
    }

    /**
     * 数组引用
     */
    // Function 中的R apply(T t)
    public void test4(){
        Function<Integer,String[]> function =length->new String[length];
        String[] apply = function.apply(5);
        System.out.print(Arrays.toString(apply));
        ///////

        Function<Integer,String[]> function1=String[]::new;

    }
}
