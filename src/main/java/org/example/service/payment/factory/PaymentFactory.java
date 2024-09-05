package org.example.service.payment.factory;

import org.example.service.payment.type.PaymentMethod;


public interface PaymentFactory {
    PaymentMethod getPaymentProvider(String type);

}
