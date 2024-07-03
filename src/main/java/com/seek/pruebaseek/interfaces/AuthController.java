package com.seek.pruebaseek.interfaces;

import com.seek.pruebaseek.infrastructure.security.JwtResponse;
import com.seek.pruebaseek.infrastructure.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    private final JwtUtil jwtUtil;

    @Autowired
    public AuthController(JwtUtil jwtTokenUtil) {
        this.jwtUtil = jwtTokenUtil;
    }

    @GetMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken() {
        // Genera un token predeterminado
        final String token = jwtUtil.generateDefaultToken();
        return ResponseEntity.ok(new JwtResponse(token));
    }
}
