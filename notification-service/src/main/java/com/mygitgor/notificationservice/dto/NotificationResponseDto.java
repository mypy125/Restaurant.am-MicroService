package com.mygitgor.notificationservice.dto;

import lombok.Data;

@Data
public class NotificationResponseDto {
    private Long userId;
    private String mail;
    private String message;
    private Status status;
}
