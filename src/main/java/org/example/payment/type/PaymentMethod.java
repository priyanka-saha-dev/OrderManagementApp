package org.example.payment.type;

@FunctionalInterface
public interface PaymentMethod {
    void accept(Double amount);
}
