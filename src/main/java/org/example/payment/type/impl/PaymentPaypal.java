package org.example.payment.type.impl;

import org.example.payment.type.PaymentMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service(PaymentPaypal.BEAN_ID)
public class PaymentPaypal implements PaymentMethod {

    public static final String BEAN_ID = "PaypalPaymentProvider";

    private static final Logger logger = LoggerFactory.getLogger(PaymentPaypal.class);
    @Override
    public void accept(Double amount) {
        logger.info("Paypal payment {} ", amount);
    }
}
