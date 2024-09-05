package org.example.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Order {

    private String orderId;
    private Double amount;
    private LocalDate orderDate;
    private String paymentType;
    private String confirmationType;

}
