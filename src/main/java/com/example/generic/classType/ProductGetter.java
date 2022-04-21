package com.example.generic.classType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 模拟抽奖
 * @author: Elliot Ji
 * @createDate: 2021-05-17
 **/
public class ProductGetter<T> {
    T product;
    private final List<T> listProd = new ArrayList<>();
    private final Random random = new Random();

    public void addProduct (T t){
        listProd.add(t);
    }

    /**
     * 普通的成员方法,此时该方法不能声明为静态方法
     * @return T
     */
    public  T getProduct(){
        product = listProd.get(random.nextInt(listProd.size()));
        return product;
    }

    /**
     * 泛型方法:
     *      1.如何定义一个泛型方法
     *      2.泛型方法独立于泛型类,即泛型方法中的泛型标识由调用方,在调用的过程中明确的
     *      3.泛型方法可以声明为静态方法
     * @param list 集合
     * @param <E>  参数
     * @return E
     */
    public <E> E getProduct(List<E> list){
        return list.get(random.nextInt(list.size()));
    }
    /*public <T> T getProduct(List<T> list){
        return list.get(random.nextInt(list.size()));
    }*/

    /**
     * 静态的泛型方法
     * @param t 参数
     * @param e
     * @param k
     * @param <T>
     * @param <E>
     * @param <K>
     */
    public static <T,E,K> void printType(T t,E e,K k){
        System.out.println(t + "\t" + t.getClass().getSimpleName());
        System.out.println(e + "\t" + e.getClass().getSimpleName());
        System.out.println(k + "\t" + k.getClass().getSimpleName());
    }

    /**
     * 泛型方法的可变参数
     * @param t
     * @param <T>
     */
    @SafeVarargs
    public static <T> void printT(T... t){
        for (T value : t) {
            System.out.println(value);
        }
    }
}
