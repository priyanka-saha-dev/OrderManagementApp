package org.example.service.confirmation.type.impl;

import org.example.service.confirmation.type.ConfirmationType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service(Email.BEAN_ID)
public class Email implements ConfirmationType {

    public static final String BEAN_ID = "EmailConfirmation";

    private final Logger logger = LoggerFactory.getLogger(Email.class);
    @Override
    public void confirm(String message) {
        logger.info("Email confirmation {} ", message);
    }
}
