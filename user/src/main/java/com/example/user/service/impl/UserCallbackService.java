package com.example.user.service.impl;

import com.example.cart.service.UserCallback;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCallbackService {
    private UserCallback callback;

    public void doSomething() {
        callback.onAction();
    }
}
