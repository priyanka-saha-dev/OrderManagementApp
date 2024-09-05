package org.example.payment.factory.impl;

import org.example.payment.factory.PaymentFactory;
import org.example.payment.type.PaymentMethod;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PaymentFactoryProvidor implements PaymentFactory {

    private final Map<String, PaymentMethod> paymentMethodMap;

    public PaymentFactoryProvidor(Map<String, PaymentMethod> paymentMethodMap) {
        this.paymentMethodMap = paymentMethodMap;
    }

    public PaymentMethod getPaymentProvider(String type) {
        return paymentMethodMap.get(type);
    }

}
