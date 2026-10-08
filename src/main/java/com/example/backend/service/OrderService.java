package com.example.backend.service;

import java.time.LocalDateTime;
import java.util.*;

import org.springframework.stereotype.Service;

import com.example.backend.entity.Order;
import com.example.backend.entity.OrderItem;
import com.example.backend.entity.Product;
import com.example.backend.entity.User;
import com.example.backend.repository.OrderRepository;
import com.example.backend.repository.ProductRepository;
import com.example.backend.repository.UserRepository;

@Service
public class OrderService {

    private UserRepository userRepository;
    private ProductRepository productRepository;
    private OrderRepository orderRepository;

    public OrderService(UserRepository userRepository, ProductRepository productRepository,
            OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Long userId, List<OrderItemRequest> items) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        Order order = new Order();

        order.setUser(user);

        order.setOrderDate(LocalDateTime.now());
        order.setStatus("Placed");

        List<OrderItem> orderItems = new ArrayList<>();

        double totalAmount = 0;

        for (OrderItemRequest itemRequest : items) {

            Product product = productRepository.findById(itemRequest.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            OrderItem orderItem = new OrderItem();

            orderItem.setProduct(product);
            orderItem.setQuantity(itemRequest.getQuantity());
            orderItem.setPrice(product.getPrice());
            orderItem.setOrder(order);

            totalAmount = product.getPrice() * itemRequest.getQuantity();

            orderItems.add(orderItem);

        }
        order.setTotalAmount(totalAmount);
        order.setItems(orderItems);

        return orderRepository.save(order);
    }

    public List<Order> getOrdersByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    public Order getOrder(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }
}
