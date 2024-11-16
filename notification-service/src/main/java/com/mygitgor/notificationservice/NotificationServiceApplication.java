package com.mygitgor.notificationservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Notification Service (Сервис уведомлений):
 * Управляет отправкой уведомлений пользователям (e-mail, SMS и т.д.).
 * API для отправки уведомлений о статусе заказа и других событиях.
 * Взаимодействует с Order Service и User Service.
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class NotificationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class, args);
    }

}
