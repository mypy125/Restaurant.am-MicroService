package com.example.cart.service;

import com.example.user.event.UserEvent;

public interface CartService {

    void handleUserEvent(UserEvent event);
}
