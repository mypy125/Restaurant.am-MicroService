package com.mygitgor.menuservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Menu Service (Сервис меню):
 * Управляет категориями меню, блюдами и их ингредиентами.
 * API для получения меню, добавления и редактирования блюд (для администраторов).
 * Взаимодействует с Order Service для предоставления информации о блюдах.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MenuServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MenuServiceApplication.class, args);
    }

}
