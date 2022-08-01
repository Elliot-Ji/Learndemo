package com.example.lambda;

import com.example.lambda.data.Person;
import org.junit.Test;

import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 内置4大函数式接口
 *  Consumer<T>
 *  Supplier<T>
 *  Function<T,R>
 *  Predicate<T>
 *
 * 1.使用函数式接口:
 *       1.定义一个函数式接口
 *       2.定义一个方法调用函数式接口,引用接口中的方法
 *       3.具体调用方法时,传入具体的方法体
 *
 * 2.方法引用: 若lambda体中的内容有方法已经实现了,我们可以就使用方法引用
 *                 (可以理解为方法引用为lambda表达式的另外一种表现形式)
 *         主要三种语法格式:
 *             对象::实例方法名
 *             类::静态方法名
 *             类::实例方法名
 *        注意:
 *         1. lambda中的方法的参数类型和返回值类型要与函数式接口中的方法保持一直
 *         2. 若lambda参数列表中的第一参数是实例方法的调用者,而第二个参数是实例方法的参数时,可以使用  类::实例方法名
 *
 * 3.构造器引用:
 *       ClassName:: new
 *
 *
 * @author: Elliot Ji
 * @createDate: 2022-07-28
 **/
public class TestLambda2 {


    @Test
    public void test2() {
        //Consumer<String> con = (x) -> System.out.println(x);对象::实例方法名
        Consumer<String> con = System.out::println;
        con.accept("check");

        Supplier<String> sup = () -> "jeck";
        System.out.println(sup.get());

        //Comparator com = (x, y) -> Integer.compare(x,y);类::静态方法名
        Comparator com1 = Integer::compare;
        System.out.println(com1.compare(4,3));

        //BiPredicate<String,String> b1 = (x,y) -> x.equals(y); 类::实例方法名
        BiPredicate<String,String> b1 = String::equals;

        //Supplier<Person> sup = () -> new Person();     构造器引用
        Supplier<Person> sup2 = Person::new;

    }

    @Test
    public void test1() {
        happy(10000,(m) -> System.out.println("apple pc 消费: " + m));
    }

    public void happy(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

}
