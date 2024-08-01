package com.mygitgor.orderservice.service.impl;

import com.mygitgor.orderservice.client.PaymentClient;
import com.mygitgor.orderservice.dto.PaymentDetails;
import com.mygitgor.orderservice.entity.Order;
import com.mygitgor.orderservice.repository.OrderRepository;
import com.mygitgor.orderservice.service.OrderService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final PaymentClient paymentClient;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentClient paymentClient) {
        this.orderRepository = orderRepository;
        this.paymentClient = paymentClient;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }

    @Override
    public Order createOrder(Order order) {
        Order createdOrder = orderRepository.save(order);
        processPayment(createdOrder.getId());
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
    public boolean processPayment(Long orderId, PaymentDetails paymentDetails) {
        PaymentDetails payment = new PaymentDetails(
                orderId,
                "CARD",
                100.0,
                "PENDING",
                LocalDateTime.now());

        PaymentDetails createdPayment = paymentClient.createPaymentDetails(paymentDetails);
        return createdPayment != null && "Completed".equals(createdPayment.getStatus());
    }
}
