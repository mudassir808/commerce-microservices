package com.example.demo.service;

import com.example.demo.client.UserClient;
import com.example.demo.dto.OrderEvent;
import com.example.demo.dto.UserResponse;
import com.example.demo.kafka.OrderProducer;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    private final UserClient userClient;
    private final OrderProducer orderProducer;

    public OrderService(UserClient userClient, OrderProducer orderProducer) {
        this.userClient = userClient;
        this.orderProducer = orderProducer;
    }

    
    @CircuitBreaker(
            name = "userService",
            fallbackMethod = "userServiceFallback"
    )
    public String placeOrder(Long userId) {

//        UserResponse user = restTemplate.getForObject(
//                "http://USER-SERVICE/users/" + userId,
//                UserResponse.class
//        );
    	UserResponse user = userClient.getUserById(userId);
    	
    	OrderEvent event = new OrderEvent(
    	        user.getId(),
    	        "Laptop",
    	        2
    	);

    	orderProducer.publish(event);

        return "Order placed successfully for " + user.getName();

    }
    
    public String userServiceFallback(
            Long userId,
            Exception ex
    ) {

        return "User Service is temporarily unavailable. Please try again later.";

    }

}
