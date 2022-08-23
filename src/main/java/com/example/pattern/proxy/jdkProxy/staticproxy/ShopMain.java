package com.example.pattern.proxy.jdkProxy.staticproxy;

/**
 * @author: Elliot Ji
 * @createDate: 2022-08-23
 **/
public class ShopMain {

    public static void main(String[] args) {
        TaoBao taoBao = new TaoBao();
        float sell = taoBao.sell(1);
        System.out.println(sell);
    }

}
