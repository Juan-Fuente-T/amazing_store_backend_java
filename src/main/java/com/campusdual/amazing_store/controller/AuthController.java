package com.campusdual.amazing_store.controller;

import com.campusdual.amazing_store.api.LoginRequest;
import com.campusdual.amazing_store.api.JwtResponse;
import com.campusdual.amazing_store.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 * Controller for handling authentication-related requests.
 * This class provides endpoints for user login and authentication.
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    /**
     * Endpoint for user login. Accepts a LoginRequest object containing username and password,
     * and returns a JWT token upon successful authentication.
     *
     * @param loginRequest the request containing username and password
     * @return ResponseEntity containing the JWT token or an unauthorized status if authentication fails
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
//            System.out.println("Intentando autenticar usuario: " + loginRequest.getUsername());
            String token = authService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
//            System.out.println("Autenticacion exitosa para usuario: " + loginRequest.getUsername());
            return ResponseEntity.ok(new JwtResponse(token));
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("Error durante la autenticacion: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new JwtResponse(null));
        }
    }
}
