package com.mygitgor.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Order Service (Сервис заказов):
 * Управляет заказами и их статусами.
 * API для создания, обновления и получения информации о заказах.
 * Интеграция с Payment Service для обработки платежей.
 * Взаимодействует с User Service для проверки прав пользователя и с Menu Service для получения информации о блюдах.
 * Order Service взаимодействует с Payment Service для обработки платежей.
 * Order Service уведомляет Notification Service о статусе заказа.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

}
