package org.example.payment.type.impl;

import org.example.payment.type.PaymentMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service(PaymentUPI.BEAN_ID)
public class PaymentUPI implements PaymentMethod {

    public static final String BEAN_ID = "UPIPaymentProvider";

    private static final Logger logger = LoggerFactory.getLogger(PaymentUPI.class);
    @Override
    public void accept(Double amount) {
        logger.info("UPI payment {} ", amount);
    }
}
