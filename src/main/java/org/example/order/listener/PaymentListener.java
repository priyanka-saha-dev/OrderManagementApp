package org.example.order.listener;

import org.example.order.Order;
import org.example.order.event.PlaceOrderEvent;
import org.example.payment.strategy.PaymentStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentListener {

    private static final Logger logger = LoggerFactory.getLogger(PaymentListener.class);

    private final PaymentStrategy paymentStrategy;

    public PaymentListener(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    @EventListener(PlaceOrderEvent.class)
    public void pay(PlaceOrderEvent placeOrderEvent) {
        Order order = placeOrderEvent.getOrder();
        logger.debug("Starting payment for Order {} !", order.getOrderId());
        this.paymentStrategy.execute(order.getPaymentType(), order.getAmount());
    }

}
