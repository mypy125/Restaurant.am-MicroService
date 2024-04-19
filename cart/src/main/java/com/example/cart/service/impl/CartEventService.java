package com.example.cart.service.impl;

import com.example.cart.service.UserCallback;
import com.example.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartEventService implements UserCallback {
    private UserService userService;

    @Override
    public void onAction() {

    }

    public void useUserService() {
        userService.doSomething();
    }


}
