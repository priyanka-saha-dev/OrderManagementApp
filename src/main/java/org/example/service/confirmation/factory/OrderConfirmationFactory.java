package org.example.service.confirmation.factory;

import org.example.service.confirmation.type.ConfirmationType;

public interface OrderConfirmationFactory {
    ConfirmationType getConfirmationType(String type);
}
