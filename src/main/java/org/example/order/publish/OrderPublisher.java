package org.example.order.publish;

import org.example.order.Order;
import org.example.order.event.PlaceOrderEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class OrderPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    public OrderPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void placeOrder(Order order) {
        // Logic to place the order


        // Publish the order placed event
        applicationEventPublisher.publishEvent(new PlaceOrderEvent(this, order));
    }
}
