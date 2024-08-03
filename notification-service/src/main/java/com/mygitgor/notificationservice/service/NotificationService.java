package com.mygitgor.notificationservice.service;

import com.mygitgor.notificationservice.dto.NotificationDetails;
import com.mygitgor.notificationservice.entity.Notification;
import com.mygitgor.notificationservice.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public Notification createNotification(NotificationDetails notificationDetails) {
        Notification notification = new Notification();
        notification.setUserId(notificationDetails.getUserId());
        notification.setMessage(notificationDetails.getMessage());
        notification.setStatus("Pending");
        notification.setCreatedDate(LocalDateTime.now());
        return notificationRepository.save(notification);
    }

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }
}
