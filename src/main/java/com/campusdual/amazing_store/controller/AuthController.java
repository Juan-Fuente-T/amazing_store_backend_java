package com.campusdual.amazing_store.controller;

import com.campusdual.amazing_store.api.LoginRequest;
import com.campusdual.amazing_store.api.JwtResponse;
import com.campusdual.amazing_store.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;


import javax.management.remote.JMXAuthenticator;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AuthService authService;

//    @PostMapping("/login")
////    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest loginRequest) {
//    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
//        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            loginRequest.getUsername(),
//                            loginRequest.getPassword()
//                    )
//            );
//            String token = authService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
////            return ResponseEntity.ok(new JwtResponse(token));
//            return ResponseEntity.ok(token);
//        }catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
//        }
//    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            System.out.println("Intentando autenticar usuario: " + loginRequest.getUsername());
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
            System.out.println("Autenticación exitosa para usuario: " + loginRequest.getUsername());

            String token = authService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
            return ResponseEntity.ok(new JwtResponse(token));
        } catch (Exception e) {
            e.printStackTrace(); // Imprime detalles del error en consola para depuración
            System.out.println("Error durante la autenticación: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new JwtResponse(null));
        }
    }
}
