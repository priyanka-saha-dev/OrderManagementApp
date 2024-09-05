package org.example.confirmation.strategy.impl;

import org.example.confirmation.factory.OrderConfirmationFactory;
import org.example.confirmation.strategy.OrderConfirmationStrategy;
import org.example.confirmation.type.ConfirmationType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OrderConfirmationStrategyExecutor implements OrderConfirmationStrategy {

    private static final Logger logger = LoggerFactory.getLogger(OrderConfirmationStrategyExecutor.class);

    private final OrderConfirmationFactory orderConfirmationFactory;

    public OrderConfirmationStrategyExecutor(OrderConfirmationFactory orderConfirmationFactory) {
        this.orderConfirmationFactory = orderConfirmationFactory;
    }

    @Override
    public void confirm(String orderId, String confirmationType) {
        logger.info("Confirmation for Order {} started !", orderId);
        ConfirmationType confirmation = this.orderConfirmationFactory.getConfirmationType(confirmationType);
        confirmation.confirm(String.format("Order %s is confirmed !", orderId));
    }
}
