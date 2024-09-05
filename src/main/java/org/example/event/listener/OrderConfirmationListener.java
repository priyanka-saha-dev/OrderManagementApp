package org.example.event.listener;

import org.example.event.OrderPaymentFailureEvent;
import org.example.service.confirmation.strategy.OrderConfirmationStrategy;
import org.example.event.OrderPaymentSuccessEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OrderConfirmationListener {

    private static final Logger logger = LoggerFactory.getLogger(OrderConfirmationListener.class);
    private final OrderConfirmationStrategy orderConfirmationStrategy;

    public OrderConfirmationListener(OrderConfirmationStrategy orderConfirmationStrategy) {
        this.orderConfirmationStrategy = orderConfirmationStrategy;
    }

    @EventListener(OrderPaymentSuccessEvent.class)
    public void confirm(OrderPaymentSuccessEvent event) {
        logger.debug("Starting successful order confirmation for {} !", event.getOrderId());
        orderConfirmationStrategy.confirm(event.getOrderId(), Optional.of(event.getConfirmationType()));
    }

    @EventListener(OrderPaymentFailureEvent.class)
    public void confirm(OrderPaymentFailureEvent event) {
        logger.debug("Starting failure order intimation for {} !", event.getOrderId());
        orderConfirmationStrategy.confirm(event.getOrderId(), Optional.empty());
    }

}
