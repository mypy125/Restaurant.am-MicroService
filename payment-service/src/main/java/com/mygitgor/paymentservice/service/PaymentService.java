package com.mygitgor.paymentservice.service;

import com.mygitgor.paymentservice.entity.Order;
import com.mygitgor.paymentservice.respons.PaymentResponse;

public interface PaymentService {
    PaymentResponse createPaymentLink(Order order)throws Exception;
}
