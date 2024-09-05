package org.example.confirmation.factory.impl;

import org.example.confirmation.factory.OrderConfirmationFactory;
import org.example.confirmation.strategy.OrderConfirmationStrategy;
import org.example.confirmation.type.ConfirmationType;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OrderConfirmationFactoryProvider implements OrderConfirmationFactory {

    private final Map<String, ConfirmationType> confirmationType;

    public OrderConfirmationFactoryProvider(Map<String, ConfirmationType> confirmationType) {
        this.confirmationType = confirmationType;
    }

    @Override
    public ConfirmationType getConfirmationType(String type) {
        return this.confirmationType.get(type);
    }
}
