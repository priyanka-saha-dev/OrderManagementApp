package org.example.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class OrderPaymentSuccessEvent extends ApplicationEvent {

    private final String orderId;
    private final String confirmationType;
    public OrderPaymentSuccessEvent(Object source, String orderId, String confirmationType) {
        super(source);
        this.orderId = orderId;
        this.confirmationType = confirmationType;
    }

}
