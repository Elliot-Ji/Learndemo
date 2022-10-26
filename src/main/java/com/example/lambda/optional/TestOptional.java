package com.example.lambda.optional;

import com.example.lambda.data.Person;
import org.junit.Test;

import java.util.Optional;

/**
 *  Optional 容器类的常用方法
 *  Optional.of(T t) : 创建一个Optional实例
 *  Optional.empty():  创建一个空的Optional实例
 *  Optional.ofNullable(T t): 若t部位null,创建Optional实例,否则创建空实例
 *  isPresent(): 判断是否包含值
 *  orElse(T t): 如果调用对象包含值,返回该值,否则返回t
 *  orElseGet(Supplier s): 如果调用对象包含值,返回该值,否则返回s 获取的值
 *  map(Function f): 如果有值对其处理,并返回处理后的optional,否则返回Optional.empty()
 *  flatMap(Function mapper): 与map类似,要求返回值必须是optional
 *
 * @author: Elliot Ji
 * @createDate: 2022-10-17
 **/
public class TestOptional {

    @Test
    public void test2() {
        Optional<Person> op = Optional.ofNullable(null);
        Person anElse = op.orElse(new Person("jfas", 44));
        System.out.println(anElse);
        System.out.println("======================================");
        Optional<Person> op1 = Optional.ofNullable(new Person());
        Person anElse1 = op1.orElse(new Person("jj", 34));
        System.out.println(anElse1);
        Person person = op.orElseGet(() -> new Person());
    }

    /**
     * 构建optional对象
     */
    @Test
    public void test1() {
        Optional<Person> op = Optional.of(new Person());
        Optional<Person> empty = Optional.empty();
        Optional<Person> person1 = Optional.ofNullable(new Person());
        Optional<Object> op2 = Optional.of(null);

        Person person = op.get();
        System.out.println(person);
    }


}
