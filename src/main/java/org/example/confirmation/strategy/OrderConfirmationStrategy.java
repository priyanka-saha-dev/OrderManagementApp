package org.example.confirmation.strategy;

public interface OrderConfirmationStrategy {
    void confirm(String orderId, String confirmationType);
}
