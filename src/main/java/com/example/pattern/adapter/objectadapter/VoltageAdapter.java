package com.example.pattern.adapter.objectadapter;

/**
 * 对象适配器
 * @author Elliot Ji
 * @date 2020/3/19.
 */
public class VoltageAdapter implements IVoltage5 {

    private Voltage220 voltage220;

    public VoltageAdapter(Voltage220 voltage220) {
        this.voltage220 = voltage220;
    }

    @Override
    public int output5() {
        int dstV = 0;
        if(null != voltage220){
            int src = voltage220.output220();
            dstV = src /44;
        }
        return dstV;
    }
}
