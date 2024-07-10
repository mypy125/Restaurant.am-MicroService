package com.mygitgor.orderservice.service;

import com.mygitgor.orderservice.entity.Order;
import com.mygitgor.orderservice.response.PaymentResponse;

public interface PaymentService {
    PaymentResponse createPaymentLink(Order order)throws Exception;
}
