package com.example.backend.entity;

import java.time.LocalDateTime;
import java.util.*;

import jakarta.persistence.*;;

@Entity
@Table(name="orders")
public class Order {
    @Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="order_seq",initialValue = 10001, allocationSize = 1)
    private Long id;

    private LocalDateTime orderDate;

    private Double totalAmount;

    private String status;

    @ManyToOne 
    @JoinColumn(name="user_id",nullable=false)
    private User user;

    @OneToMany(mappedBy="order",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<OrderItem> items = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    

    
}
