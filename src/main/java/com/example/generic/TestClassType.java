package com.example.generic;

import com.example.generic.classType.ProductGetter;
import com.example.generic.interfaceType.Test02;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Elliot Ji
 * @createDate: 2021-05-17
 **/
public class TestClassType {
    public static void main(String[] args) {
        ProductGetter<String> productGetter = new ProductGetter<>();
        String[] str = {"苹果手机","华为手机","咖啡机","扫地机器人"};
        for (String s : str) {
            productGetter.addProduct(s);
        }
        String product = productGetter.getProduct();
        System.out.println(product);

        System.out.println("=====================================");
        ProductGetter<Integer> products = new ProductGetter<>();
        List<String> ll = new ArrayList<>();
        ll.add("机械键盘");
        ll.add("鼠标");
        ll.add("电脑");
        String product1 = products.getProduct(ll);
        System.out.println(product1 + "\t"+"泛型方法的使用");

        System.out.println("-------------------------------------");
        ProductGetter.printType(100,"adb",true);

        System.out.println("-------------------------------------");
        ProductGetter.printT(100,200,300,400,500);

        System.out.println("-------------------------------------");
        Test02<String,Integer> test02 = new Test02<>("count",1000);
        System.out.println(test02.getKey() + "=" + test02.getValue());

    }
}
