package com.mygitgor.notificationservice.controller;


import com.mygitgor.notificationservice.dto.NotificationDetails;
import com.mygitgor.notificationservice.entity.Notification;
import com.mygitgor.notificationservice.service.NotificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public Notification createNotification(@RequestBody NotificationDetails notificationDetails) {
        return notificationService.createNotification(notificationDetails);
    }

    @GetMapping
    public List<Notification> getAllNotifications() {
        return notificationService.getAllNotifications();
    }
}