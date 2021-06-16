package com.example.pattern.adapter.classadapter;

/**
 * 类适配器:
 *   最大的作用就是将原本不兼容的接口融合在一起工作
 * @author Elliot Ji
 * @date 2020/3/19.
 */
public class VoltageAdapter extends Voltage220 implements IVoltage5 {
    @Override
    public int output5() {
        int srcV = output220();
        int dstV = srcV / 44;
        return dstV;
    }
}
