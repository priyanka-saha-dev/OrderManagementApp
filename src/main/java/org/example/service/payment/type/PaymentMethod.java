package org.example.service.payment.type;

@FunctionalInterface
public interface PaymentMethod {
    Boolean accept(Double amount);
}
