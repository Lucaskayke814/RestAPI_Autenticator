package com.example.controller;

import com.example.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public Object login(@RequestParam("userName") String userName, @RequestParam("senha") String senha) {
        try {
            if (authService.authenticate(userName, senha)) {
                return authService.generateToken(userName);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro não tratado: " + e.getMessage());
        }
    }

    @GetMapping("/user")
    public Object getUser(Authentication authentication) {
        try {
            return "USER: " + authentication.getName();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro não tratado: " + e.getMessage());
        }
    }

    @Secured("ADMIN")
    @GetMapping("/admin")
    public Object onlyAdmin(Authentication authentication) {
        try {
            return "ADMIN: " + authentication.getName();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro não tratado: " + e.getMessage());
        }
    }
}
