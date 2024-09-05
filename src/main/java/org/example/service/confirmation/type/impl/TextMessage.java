package org.example.service.confirmation.type.impl;

import org.example.service.confirmation.type.ConfirmationType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service(TextMessage.BEAN_ID)
public class TextMessage implements ConfirmationType {

    public static final String BEAN_ID = "TextMessageConfirmation";

    private final Logger logger = LoggerFactory.getLogger(TextMessage.class);
    @Override
    public void confirm(String message) {
        logger.info("TextMessage confirmation {} ", message);
    }
}
