package com.mygitgor.orderservice.service;

import com.mygitgor.orderservice.dto.PaymentDetails;
import com.mygitgor.orderservice.entity.Order;
import com.mygitgor.orderservice.entity.OrderItem;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> getAllOrders();
    Optional<Order> getOrderById(Long orderId);
    Order createOrder(Order order);
    Order updateOrder(Long orderId, Order orderDetails);
    void deleteOrder(Long orderId);
    boolean processPayment(Long orderId, PaymentDetails paymentDetails);
}
