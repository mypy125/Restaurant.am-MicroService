package com.mygitgor.notificationservice.client;

import com.mygitgor.orderservice.dto.PaymentDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "payment-service", url = "http://localhost:8081/api/payments")
public interface PaymentClient {
    @GetMapping("/{orderId}")
    PaymentDetails getPaymentDetailsByOrderId(@PathVariable("orderId") Long orderId);
}
