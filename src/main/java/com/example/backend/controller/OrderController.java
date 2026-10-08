package com.example.backend.controller;

import com.example.backend.entity.Order;
import com.example.backend.service.OrderItemRequest;
import com.example.backend.service.OrderService;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin
public class OrderController {

    private final OrderService orderService;

    OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/user/{userId}")
    public List<Order> getOrders(@PathVariable Long userId) {
        return orderService.getOrdersByUserId(userId);
    }

    @PostMapping
    public Order createOrder(@RequestParam Long userId,@RequestBody List<OrderItemRequest> items) {
        return orderService.createOrder(userId,items);
    }

}
