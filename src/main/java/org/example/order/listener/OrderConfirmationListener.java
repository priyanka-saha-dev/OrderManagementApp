package org.example.order.listener;

import org.example.confirmation.strategy.OrderConfirmationStrategy;
import org.example.order.Order;
import org.example.order.event.PlaceOrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConfirmationListener {

    private static final Logger logger = LoggerFactory.getLogger(OrderConfirmationListener.class);
    private final OrderConfirmationStrategy orderConfirmationStrategy;

    public OrderConfirmationListener(OrderConfirmationStrategy orderConfirmationStrategy) {
        this.orderConfirmationStrategy = orderConfirmationStrategy;
    }

    @EventListener(PlaceOrderEvent.class)
    public void confirm(PlaceOrderEvent placeOrderEvent) {
        Order order = placeOrderEvent.getOrder();
        logger.debug("Starting order confirmation for Order {} !", order.getOrderId());
        orderConfirmationStrategy.confirm(order.getOrderId(), order.getConfirmationType());
    }

}
