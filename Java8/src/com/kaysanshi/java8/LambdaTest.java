package com.kaysanshi.java8;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @Author kay三石
 * @date:2020/2/13
 */
public class LambdaTest {
    /**
     * Lambda表达式：
     * lambda是一个匿名函数可以理解为可传递的代码
     * 举例： (o1, o2) -> Integer.compare(o1,o2)
     * 格式：
     *      -> ：lambda表达式的操作符， 或  箭头函数的操作符
     *      (左边)-> ：左边是lambda的形参列表，其实就是接口中的抽象方法的形参列表
     *      ->(右边) lambda体，其实就是重写的抽象的方法体 使用{}包裹， 省略{}必须胜率return
     *  3.lambda表达式的使用 分6中情况介绍
     *
     *     1：无参，无返回值
     *     2：需要一个参数，无返回值
     *     3：数据类型可省略，由编辑器进行类型推断，“类型推断”
     *     4：lambda若只需要一个参数则参数小括号可省
     *     5：Lambda需要两个或以上的参数，多条执行语句，并且可有返回值
     *     6：Lambda体只有一条语句时，return与大括号若有则都可以省去
     *  4.lambda表达式的本质：作为接口的实例
     *  函数式接口 java.util.function包：
     *  5.如果一个接口中，只声明一个抽象方法，这个接口的称为函数式接口
     *  函数式接口：只包含一个抽象方法。
     *  可以使用@@FunctionalInterface检验一个接口是不是函数式接口。
     *  6.以前的匿名实现类表示的现在都可以用lambda表达式书写。
     *
     */



    @Test
    public void test1() {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("原生的");
            }
        };
        r1.run();
        System.out.print("-------lambda表达式测试1：无参，无返回值");
        Runnable r2 = () -> System.out.print("我亲爱lambda");
        r2.run();
    }

    @Test
    public void test2(){
        /**
         * 需要有参数，但是无返回值
         */
        //Consumer接口：给定义一个参数,对其进行(消费)处理,处理的方式可以是任意操作
        /**
         * void accept(T t);
         * 对给定的参数T执行定义的操作
         *
         * default Consumer andThen(Consumer<? super T> after)
         * 对给定的参数T执行定义的操作执行再继续执行after定义的操作
         */
        Consumer<String> consumer=new Consumer <String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("试验和谎言的区别");
        System.out.print("********lambda表达式：需要有参数，但是无返回值 *******");
        Consumer<String> consumer1=(String s)->{System.out.print(s);};
        consumer1.accept("一个听的人当真了，一个说的人当真了");

    }
    // 语法格式3： 数据类型可省略，由编辑器进行类型推断，“类型推断”
    // 和泛型一样。。。
    public void test3(){
        Consumer<String> consumer1=(s)->{System.out.print(s);};
        consumer1.accept("一个听的人当真了，一个说的人当真了");
    }
    // 语法格式4：lambda若只需要一个参数则参数小括号可省
    public void test4(){
        Consumer<String> consumer1=s->{System.out.print(s);};
        consumer1.accept("一个听的人当真了，一个说的人当真了");
    }
    // 语法格式5：Lambda体需要两个或以上的参数，多条执行语句，并且可有返回值
    @Test
    public void test5(){
        // 强行对某个对象 collection 进行整体排序的比较函数
        // 返回 -1 后者大于前者
        // 返回 1则是前者大于后者
        // 返回0相等
        Comparator<Integer> comparator=(x,y)->{
            System.out.print("实现函数式接口方法！");
            return Integer.compare(x,y);
        };
        System.out.print(comparator.compare(1,1));
    }
    // 语法格式6：Lambda体只有一条语句时，return与大括号若有则都可以省去

    @Test
    public void test6(){
        Comparator<Integer> comparator=(x,y)->Integer.compare(x,y);
        System.out.print(comparator.compare(15,3));

    }
    @Test
    public void test22(){
        // 比较两个数
        Comparator<Integer> com1 = new Comparator <Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        int compare1=com1.compare(12,22);

        System.out.println(compare1);

        System.out.println("------------------");
        // lambda表达式的写法
        Comparator<Integer> comparator=(o1, o2) -> Integer.compare(o1,o2);
        int compare2=comparator.compare(52,22);

        System.out.println(compare2);

        System.out.println("------------------");

        // 方法引用的写法
        Comparator<Integer> comparator2=Integer::compare;
        int compare3=comparator2.compare(12,22);

        System.out.println(compare3);
    }

}
