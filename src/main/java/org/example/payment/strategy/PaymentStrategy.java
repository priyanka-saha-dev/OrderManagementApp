package org.example.payment.strategy;

public interface PaymentStrategy {
    void execute(String paymentMethodType, Double amount);
}

