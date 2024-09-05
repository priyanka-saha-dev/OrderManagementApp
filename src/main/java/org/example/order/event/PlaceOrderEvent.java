package org.example.order.event;

import lombok.Getter;
import org.example.order.Order;
import org.springframework.context.ApplicationEvent;

@Getter
public class PlaceOrderEvent extends ApplicationEvent {

    private final Order order;

    public PlaceOrderEvent(Object source, Order order) {
        super(source);
        this.order = order;
    }

}
