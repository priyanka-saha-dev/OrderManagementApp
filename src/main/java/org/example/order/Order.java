package org.example.order;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {

    private String orderId;
    private Double amount;
    private String paymentType;
    private String confirmationType;

}
