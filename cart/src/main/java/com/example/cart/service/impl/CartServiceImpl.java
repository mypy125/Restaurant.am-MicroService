package com.example.cart.service.impl;

import com.example.cart.service.CartService;
import com.example.user.event.UserEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CartServiceImpl implements CartService {

    @Override
    @EventListener
    public void handleUserEvent(UserEvent event) {
        // Обработка события
    }
}
