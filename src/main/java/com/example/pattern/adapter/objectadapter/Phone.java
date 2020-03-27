package com.example.pattern.adapter.objectadapter;

/**
 * @author Elliot Ji
 * @date 2020/3/19.
 */
public class Phone {

    public void charging(IVoltage5 iVoltage5){
        if(iVoltage5.output5() == 5){
            System.out.println("电压5V,可以充电");
        }else if(iVoltage5.output5() > 5){
            System.out.println("电压大于5V,不可充电");
        }
    }

}
