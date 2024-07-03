package com.seek.pruebaseek.domain.dto;

import lombok.Data;

@Data
public class AuthResponse {
    private final String jwt;

    public AuthResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
