package org.example.service.confirmation.strategy;

import java.util.Optional;

public interface OrderConfirmationStrategy {
    void confirm(String orderId, Optional<String> confirmationType);
}
