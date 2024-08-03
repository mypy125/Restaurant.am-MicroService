package com.mygitgor.orderservice.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NotificationDetails {
    private Long userId;
    private String message;
    private String status;
    private LocalDateTime createdDate;

    public NotificationDetails() {}
    public NotificationDetails(Long userId,
                               String message,
                               String status,
                               LocalDateTime createdDate) {
        this.userId = userId;
        this.message = message;
        this.status = status;
        this.createdDate = createdDate;
    }

}
