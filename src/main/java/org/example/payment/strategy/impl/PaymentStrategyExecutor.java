package org.example.payment.strategy.impl;

import org.example.payment.factory.PaymentFactory;
import org.example.payment.strategy.PaymentStrategy;
import org.example.payment.type.PaymentMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PaymentStrategyExecutor implements PaymentStrategy {

    private static final Logger logger = LoggerFactory.getLogger(PaymentStrategyExecutor.class);

    private final PaymentFactory paymentFactory;

    public PaymentStrategyExecutor(PaymentFactory paymentFactory) {
        this.paymentFactory = paymentFactory;
    }

    @Override
    public void execute(String paymentMethodType, Double amount) {
        logger.info("Paying {} via {}", amount, paymentMethodType);
        PaymentMethod paymentMethod = this.paymentFactory.getPaymentProvider(paymentMethodType);
        paymentMethod.accept(amount);
    }
}
