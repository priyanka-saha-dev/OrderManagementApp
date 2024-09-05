package org.example.event.listener;

import org.example.model.Order;
import org.example.event.OrderPlacedEvent;
import org.example.service.payment.strategy.PaymentStrategy;
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

    @EventListener(OrderPlacedEvent.class)
    public void pay(OrderPlacedEvent event) {
        Order order = event.getOrder();
        logger.debug("Starting payment for Order {} !", order.getOrderId());
        this.paymentStrategy.execute(order.getPaymentType(), order.getAmount(), order.getOrderId(), order.getConfirmationType());
    }

}
