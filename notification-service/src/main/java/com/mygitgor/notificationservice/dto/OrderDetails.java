package com.mygitgor.notificationservice.dto;

import com.mygitgor.orderservice.entity.OrderItem;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderDetails {
    private Long id;
    private Long userId;
    private List<OrderItem> items;
    private Double totalAmount;
    private String status;
    private LocalDateTime createdDate;
}
