package com.mygitgor.orderservice.client;

import com.mygitgor.orderservice.dto.NotificationDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notification-service", url = "http://localhost:8082/api/notifications")
public interface NotificationClient {

    @PostMapping
    void createNotification(@RequestBody NotificationDetails notificationDetails);
}