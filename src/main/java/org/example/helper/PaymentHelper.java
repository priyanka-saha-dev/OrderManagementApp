package org.example.helper;

import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PaymentHelper {

    public LocalDateTime getPaymentTimestamp() {
        return LocalDateTime.now();
    }

}
