package org.example.confirmation.factory;

import org.example.confirmation.type.ConfirmationType;

public interface OrderConfirmationFactory {
    ConfirmationType getConfirmationType(String type);
}
