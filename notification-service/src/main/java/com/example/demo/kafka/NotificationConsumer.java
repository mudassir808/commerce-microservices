package com.example.demo.kafka;

import com.example.demo.dto.OrderEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    @KafkaListener(
            topics = "order-events",
            groupId = "notification-group"
    )
    public void consume(OrderEvent event) {

        System.out.println("=================================");
        System.out.println("Order Received");
        System.out.println(event);
        System.out.println("=================================");

    }

}
