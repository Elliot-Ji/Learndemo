package com.example.pattern.listener;

import java.util.EventObject;

/**
 * 监听器模式
 *  (1).构成要素
 *       1.事件源: 事件发生的源头,比如被点击的按钮,属于被监听的对象
 *       2.事件对象: 用来包装事件源,是一个事件,如点击事件;   ClickEvent
 *       3.监听器: 核心,定义事件发生后的动作,通常事件对象作为监听器中定义的函数入参
 * @author: Elliot Ji
 * @createDate: 2022-08-01
 **/
public class ClickEvent extends EventObject {

    private int id;
    public final static int SINGLE_CLICK = 1;
    public final static int DOUBLE_CLICK = 2;

    public ClickEvent(Object source) {
        super(source);
    }

    public ClickEvent(Object source, int id) {
        super(source);
        switch (id) {
            case SINGLE_CLICK:
                this.id = SINGLE_CLICK;
                break;
            case DOUBLE_CLICK:
                this.id =  DOUBLE_CLICK;
                break;
        }
    }

    public int getId() {
        return this.id;
    }
}
