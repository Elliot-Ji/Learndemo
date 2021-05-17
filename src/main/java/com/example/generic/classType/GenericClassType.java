package com.example.generic.classType;

/**
 * 泛型类: 通过一个类,来处理不同类型的数据,达到代码复用的功能;
 *      1.如何定义一个泛型类
 *      2.如何使用泛型类
 *   注意事项: (1). 泛型类,没有指定具体的数据类型时,默认是Object类型
 *           (2).泛型的类型参数(形参)只能是类类型,不能是基本数据类型;
 *           (3).泛型类型逻辑上看上去是多个不同的类型,实际上都是相同类型;
 * 泛型类派生子类:
 *      1. 子类也是泛型类时,继承父类(泛型类),泛型类型(泛型标识)要一致;
 *      2. 子类是普通类时,继承父类,父类的泛型标识必须要明确指出;
 *
 * 类型通配符:
 *      1. ? 是类型实参,不是类型型参
 *      2. ? 来指定类型实参的上限 如: <? extends Number>,即该实参只能是Number类型或者其子类
 *      3. ? 来指定类型实参的下限 如: <? super Number>,即该实参只能是Number类型或者其父类
 * @author: Elliot Ji
 * @createDate: 2021-05-17
 **/
public class GenericClassType<T> {
    private T key;

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public GenericClassType(T key) {
        this.key = key;
    }

    public GenericClassType() {
    }

    @Override
    public String toString() {
        return "GenericClassType{" +
                "key=" + key +
                '}';
    }
}
