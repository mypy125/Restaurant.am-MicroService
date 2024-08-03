package com.mygitgor.orderservice.dto;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Data
public class PaymentDetails{
        private Long id;
        private Long orderId;
        private String paymentMethod;
        private Double amount;
        private String status;
        private LocalDateTime paymentDate;

    public PaymentDetails(Long orderId,
                          String paymentMethod,
                          Double amount,
                          String status,
                          LocalDateTime paymentDate) {
        this.orderId = orderId;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.status = status;
        this.paymentDate = paymentDate;
    }

}
