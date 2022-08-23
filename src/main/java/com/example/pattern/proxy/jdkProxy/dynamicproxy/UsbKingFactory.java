package com.example.pattern.proxy.jdkProxy.dynamicproxy;


/**
 * @author: Elliot Ji
 * @createDate: 2022-08-23
 **/
public class UsbKingFactory implements UsbSell {

    @Override
    public float sell(int amount) {
        return 85.0f;
    }

}
