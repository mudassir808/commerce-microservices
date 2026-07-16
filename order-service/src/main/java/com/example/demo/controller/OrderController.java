package com.example.demo.controller;

import com.example.demo.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/{userId}")
    public String placeOrder(@PathVariable Long userId) {

        return orderService.placeOrder(userId);

    }

}
