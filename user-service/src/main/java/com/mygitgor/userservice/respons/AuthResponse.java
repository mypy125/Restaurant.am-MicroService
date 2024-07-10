package com.mygitgor.userservice.respons;

import com.mygitgor.userservice.entity.Role;
import lombok.Data;

@Data
public class AuthResponse {
    private String jwt;
    private String massage;
    private Role role;
}