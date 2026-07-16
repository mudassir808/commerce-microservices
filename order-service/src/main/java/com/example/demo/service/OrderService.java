package com.example.demo.service;

import com.example.demo.client.UserClient;
import com.example.demo.dto.UserResponse;
import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    private final UserClient userClient;

    public OrderService(UserClient userClient) {
        this.userClient = userClient;
    }

    public String placeOrder(Long userId) {

//        UserResponse user = restTemplate.getForObject(
//                "http://USER-SERVICE/users/" + userId,
//                UserResponse.class
//        );
    	UserResponse user = userClient.getUserById(userId);

        return "Order placed successfully for " + user.getName();

    }

}
