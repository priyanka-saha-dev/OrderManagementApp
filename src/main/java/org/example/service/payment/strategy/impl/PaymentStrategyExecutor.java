package org.example.service.payment.strategy.impl;

import org.example.event.OrderPaymentFailureEvent;
import org.example.helper.PaymentHelper;
import org.example.event.OrderPaymentSuccessEvent;
import org.example.service.payment.factory.PaymentFactory;
import org.example.service.payment.strategy.PaymentStrategy;
import org.example.service.payment.type.PaymentMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class PaymentStrategyExecutor implements PaymentStrategy {

    private static final Logger logger = LoggerFactory.getLogger(PaymentStrategyExecutor.class);

    private final PaymentFactory paymentFactory;
    private final PaymentHelper paymentHelper;

    private final ApplicationEventPublisher applicationEventPublisher;

    public PaymentStrategyExecutor(PaymentFactory paymentFactory, PaymentHelper paymentHelper, ApplicationEventPublisher applicationEventPublisher) {
        this.paymentFactory = paymentFactory;
        this.paymentHelper = paymentHelper;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void execute(String paymentMethodType, Double amount, String orderId, String confirmationType) {
        logger.info("Paying {} via {}", amount, paymentMethodType);
        PaymentMethod paymentMethod = this.paymentFactory.getPaymentProvider(paymentMethodType);
        Boolean status = paymentMethod.accept(amount);

        if(status) {
            logger.info("Payment completed at {} ", paymentHelper.getPaymentTimestamp());
            applicationEventPublisher.publishEvent(new OrderPaymentSuccessEvent(this, orderId, confirmationType));
        } else {
            logger.info("Payment failed at {} ", paymentHelper.getPaymentTimestamp());
            applicationEventPublisher.publishEvent(new OrderPaymentFailureEvent(this, orderId));
        }
    }
}
