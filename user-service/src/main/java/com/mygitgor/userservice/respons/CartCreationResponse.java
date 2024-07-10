package com.mygitgor.userservice.respons;

import lombok.Data;

@Data
public class CartCreationResponse {
    private String message;
    private AuthResponse authResponse;
}
