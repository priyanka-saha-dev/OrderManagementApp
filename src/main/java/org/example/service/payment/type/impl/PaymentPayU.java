package org.example.service.payment.type.impl;

import org.example.service.payment.type.PaymentMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service(PaymentPayU.BEAN_ID)
public class PaymentPayU implements PaymentMethod {

    public static final String BEAN_ID = "PayUPaymentProvider";

    private static final Logger logger = LoggerFactory.getLogger(PaymentPayU.class);
    @Override
    public Boolean accept(Double amount) {
        logger.info("PayU payment {} ", amount);
        return Boolean.FALSE;
    }
}
