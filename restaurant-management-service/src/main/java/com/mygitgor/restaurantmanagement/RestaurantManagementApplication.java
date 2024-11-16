package com.mygitgor.restaurantmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Restaurant Management Service (Сервис управления рестораном):
 * Управляет информацией о ресторане, контактными данными и адресами.
 * API для получения и обновления информации о ресторане.
 * Взаимодействует с Menu Service и Order Service.
 * Restaurant Management Service предоставляет информацию о ресторане для Menu Service и Order Service.
 */
@SpringBootApplication
public class RestaurantManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantManagementApplication.class, args);
    }

}
