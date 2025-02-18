package com.example.iText;

import lombok.Data;

/**
 * @author Elliot Ji
 * @date 2024/08/28
 */
@Data
public class TmpModel {
    private String type; //仪器型号
    private String name; //仪器名称
    private String pict; //仪器图片
    private String cify;// 仪器分类
    private String instrum_mer; //仪器制造商
    private String s_dom; //服务内容
    private String orival; //50.00万元
    private String r_rates; //收费标准
    private String u_address; //地址
    private String put_address; //存放地区（所属区）
    private String dept_name; //所属单位
    private String linkman; //联系人
    private String phone; //联系方式

    private String technical_index;//技术指标



}
