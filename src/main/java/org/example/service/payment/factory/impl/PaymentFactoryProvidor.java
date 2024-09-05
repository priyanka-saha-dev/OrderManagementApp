package org.example.service.payment.factory.impl;

import org.example.service.payment.factory.PaymentFactory;
import org.example.service.payment.type.PaymentMethod;
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
