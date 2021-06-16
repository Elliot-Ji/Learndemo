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
    private T product;
    private List<T> listProd = new ArrayList<>();
    private Random random = new Random();

    public void addProduct (T t){
        listProd.add(t);
    }

    /**
     * 普通的成员方法,此时该方法不能声明为静态方法
     * @return
     */
    public  T getProduct(){
        product = listProd.get(random.nextInt(listProd.size()));
        return product;
    }

    /**
     * 泛型方法:
     *      1.如何定义一个泛型方法
     *      2.泛型方法独立于泛型类,即泛型方法中的泛型标识有调用方,在调用的过程中明确的
     *      3.泛型方法可以声明为静态方法
     * @param list
     * @param <E>
     * @return
     */
    public <E> E getProduct(List<E> list){
        return list.get(random.nextInt(list.size()));
    }
    /*public <T> T getProduct(List<T> list){
        return list.get(random.nextInt(list.size()));
    }*/

    /**
     * 静态的泛型方法
     * @param t
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
    public static <T> void printT(T... t){
        for (int i = 0; i < t.length; i++) {
            System.out.println(t[i]);
        }
    }
}
