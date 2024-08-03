package com.mygitgor.notificationservice.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Notification extends BaseEntity<Long> {
    private Long userId;
    private String message;
    private String status;
    private LocalDateTime createdDate;
}
