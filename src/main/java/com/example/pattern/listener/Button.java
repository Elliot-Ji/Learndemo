package com.example.pattern.listener;

import java.util.EventObject;

/**
 * 事件源: Button
 *
 * @author: Elliot Ji
 * @createDate: 2022-08-01
 **/
public class Button {

    private OnClickListener clickListener;

    public void setOnClickListener(OnClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public void handleEvent(EventObject e) {
        if (e instanceof ClickEvent) {
            ClickEvent event = (ClickEvent) e;

        }
    }

}
