package com.mygitgor.orderservice.dto;

import java.time.LocalDateTime;

public record PaymentDetails(
        Long id,
        Long orderId,
        String paymentMethod,
        Double amount,
        String status,
        LocalDateTime paymentDate
) {
}
