package com.mygitgor.notificationservice.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NotificationDetails {
    private Long id;
    private Long userId;
    private String message;
    private String status;
    private LocalDateTime createdDate;

    public NotificationDetails(Long userId,
                               String message,
                               String status,
                               LocalDateTime createdDate) {
        this.userId = userId;
        this.message = message;
        this.status = status;
        this.createdDate = createdDate;
    }

    public NotificationDetails(Long id,
                               Long userId,
                               String message,
                               String status,
                               LocalDateTime createdDate) {
        this.id = id;
        this.userId = userId;
        this.message = message;
        this.status = status;
        this.createdDate = createdDate;
    }

}
