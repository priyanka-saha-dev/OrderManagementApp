package org.example.service.confirmation.strategy.impl;

import org.example.service.confirmation.factory.OrderConfirmationFactory;
import org.example.service.confirmation.strategy.OrderConfirmationStrategy;
import org.example.service.confirmation.type.ConfirmationType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class OrderConfirmationStrategyExecutor implements OrderConfirmationStrategy {

    private static final Logger logger = LoggerFactory.getLogger(OrderConfirmationStrategyExecutor.class);

    private final OrderConfirmationFactory orderConfirmationFactory;

    public OrderConfirmationStrategyExecutor(OrderConfirmationFactory orderConfirmationFactory) {
        this.orderConfirmationFactory = orderConfirmationFactory;
    }

    @Override
    public void confirm(String orderId, Optional<String> confirmationType) {
        logger.info("Confirmation for Order {} started !", orderId);
        confirmationType.ifPresent(c -> sendConfirmation(orderId, c));

    }

    private void sendConfirmation(String orderId, String confirmationType) {
        ConfirmationType confirmation = this.orderConfirmationFactory.getConfirmationType(confirmationType);
        confirmation.confirm(String.format("Order %s is confirmed !", orderId));
    }
}
