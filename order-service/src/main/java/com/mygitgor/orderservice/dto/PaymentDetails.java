package com.mygitgor.orderservice.dto;

import java.time.LocalDateTime;

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

    public Long getId() {
        return id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public Double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }
}
