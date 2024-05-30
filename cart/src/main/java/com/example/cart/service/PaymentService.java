package com.example.cart.service;

import com.example.cart.entity.Order;
import com.example.cart.response.PaymentResponse;

public interface PaymentService {
    PaymentResponse createPaymentLink(Order order)throws Exception;
}
