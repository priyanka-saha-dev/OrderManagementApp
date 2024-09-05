package org.example;


import org.example.service.confirmation.type.impl.Email;
import org.example.helper.OrderManagementHelper;
import org.example.model.Order;
import org.example.event.publish.OrderPublisher;
import org.example.service.payment.type.impl.PaymentPayU;
import org.example.service.payment.type.impl.PaymentUPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderManagementApp implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(OrderManagementApp.class);

    private final OrderPublisher orderPublisher;

    public OrderManagementApp(OrderPublisher orderPublisher) {
        this.orderPublisher = orderPublisher;
    }


    public static void main(String[] args) {
        SpringApplication.run(OrderManagementApp.class, args);
    }

    @Override
    public void run(String... args) {
        logger.info("Order Management App");
        placeOrder();
    }

    private void placeOrder() {

        Order order = Order.builder()
                .orderId("O1")
                .orderDate(OrderManagementHelper.getInstance().toLocalDate("2024-09-04"))
                .paymentType(PaymentPayU.BEAN_ID)
                .amount(599.99)
                .confirmationType(Email.BEAN_ID)
                .build();

        logger.info("Placing Order {}", order);
        this.orderPublisher.placeOrder(order);

    }
}