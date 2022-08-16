package com.example.pattern.listener;

import java.util.EventListener;

/**
 * 监听器要继承EventListener
 * @author: Elliot Ji
 * @createDate: 2022-08-01
 **/
public interface OnClickListener extends EventListener {

    void click(ClickEvent clickEvent);

    void doubleClick(ClickEvent clickEvent);

}
