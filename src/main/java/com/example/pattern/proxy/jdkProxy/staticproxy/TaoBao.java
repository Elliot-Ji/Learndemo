package com.example.pattern.proxy.jdkProxy.staticproxy;

/**
 * @author: Elliot Ji
 * @createDate: 2022-08-23
 **/
public class TaoBao implements UsbSell {

    private final UsbSell factory = new UsbKingFactory();

    @Override
    public float sell(int amount) {

        float price = factory.sell(amount);

        price =  price + 25;
        return price;
    }

}
