package org.example.payment.factory;

import org.example.payment.type.PaymentMethod;


public interface PaymentFactory {
    PaymentMethod getPaymentProvider(String type);

}
