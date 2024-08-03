package com.mygitgor.orderservice.service.impl;

import com.mygitgor.orderservice.dto.NotificationDetails;
import com.mygitgor.orderservice.client.NotificationClient;
import com.mygitgor.orderservice.client.PaymentClient;
import com.mygitgor.orderservice.dto.PaymentDetails;
import com.mygitgor.orderservice.entity.Order;
import com.mygitgor.orderservice.repository.OrderRepository;
import com.mygitgor.orderservice.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final PaymentClient paymentClient;
    private final NotificationClient notificationClient;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentClient paymentClient, NotificationClient notificationClient) {
        this.orderRepository = orderRepository;
        this.paymentClient = paymentClient;
        this.notificationClient = notificationClient;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }

    @Transactional
    public Order createOrder(Order order) {
        Order createdOrder = orderRepository.save(order);
        if (!processPayment(createdOrder)) {
            throw new RuntimeException("Payment processing failed for order ID: " + createdOrder.getId());
        }
        sendOrderNotification(createdOrder);
        return createdOrder;
    }

    @Override
    public Order updateOrder(Long orderId, Order orderDetails) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(orderDetails.getStatus());
        order.setItems(orderDetails.getItems());
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public boolean processPayment(Order order) {
        PaymentDetails paymentDetails = new PaymentDetails(
                order.getId(),
                "Credit Card",
                order.getTotalAmount(),
                "Pending",
                LocalDateTime.now()
        );

        try {
            PaymentDetails createdPayment = paymentClient.createPaymentDetails(paymentDetails);
            boolean isSuccess = createdPayment != null && "Completed".equals(createdPayment.getStatus());
            if (isSuccess) {
                sendPaymentNotification(order);
            }
            return isSuccess;
        } catch (Exception e) {
            System.err.println("Payment processing failed: " + e.getMessage());
            return false;
        }
    }

    private void sendOrderNotification(Order order) {
        NotificationDetails notificationDetails = new NotificationDetails(
                order.getUserId(),
                "Your order has been placed successfully.",
                "Pending",
                LocalDateTime.now()
        );
        notificationClient.createNotification(notificationDetails);
    }

    private void sendPaymentNotification(Order order) {
        NotificationDetails notificationDetails = new NotificationDetails(
                order.getUserId(),
                "Your payment has been completed successfully.",
                "Pending",
                LocalDateTime.now()
        );
        notificationClient.createNotification(notificationDetails);
    }
}
