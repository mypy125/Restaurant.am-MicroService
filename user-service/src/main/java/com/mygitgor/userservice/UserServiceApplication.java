package com.mygitgor.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * User Service (Сервис пользователей):
 * Управляет информацией о пользователях и ролях.
 * API для регистрации, аутентификации и управления пользователями.
 * User Service взаимодействует с Order Service для проверки прав пользователя.
 */
@SpringBootApplication
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

}
