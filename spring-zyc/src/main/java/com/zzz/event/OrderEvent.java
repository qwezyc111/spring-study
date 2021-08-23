package com.zzz.event;

import org.springframework.context.ApplicationEvent;

// 订单事件
@SuppressWarnings("serial")
public class OrderEvent  extends ApplicationEvent {

    private String name;

    public OrderEvent(Object source, String name) {
        super(source);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}