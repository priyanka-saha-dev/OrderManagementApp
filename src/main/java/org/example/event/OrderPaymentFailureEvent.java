package org.example.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class OrderPaymentFailureEvent extends ApplicationEvent {

    private final String orderId;
    public OrderPaymentFailureEvent(Object source, String orderId) {
        super(source);
        this.orderId = orderId;
    }

}
