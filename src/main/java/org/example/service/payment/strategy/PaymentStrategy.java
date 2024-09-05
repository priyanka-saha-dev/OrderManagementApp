package org.example.service.payment.strategy;

public interface PaymentStrategy {
    void execute(String paymentMethodType, Double amount, String orderId, String confirmationType);
}

