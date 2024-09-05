package org.example.event.publish;

import org.example.model.Order;
import org.example.event.OrderPlacedEvent;
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
        applicationEventPublisher.publishEvent(new OrderPlacedEvent(this, order));
    }
}
