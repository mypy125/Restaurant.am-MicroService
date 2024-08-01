package com.mygitgor.orderservice.client;

import com.mygitgor.orderservice.dto.PaymentDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "payment-service", url = "http://localhost:8081/api/payments")
public interface PaymentClient {
    @PostMapping
    PaymentDetails createPaymentDetails(@RequestBody PaymentDetails paymentDetails);
}
