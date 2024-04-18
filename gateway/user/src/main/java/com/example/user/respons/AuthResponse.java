package com.example.user.respons;

import com.example.user.entity.Role;
import lombok.Data;

@Data
public class AuthResponse {
    private String jwt;
    private String massage;
    private Role role;
}