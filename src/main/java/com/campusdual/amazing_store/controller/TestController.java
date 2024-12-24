package com.campusdual.amazing_store.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * Controller for handling test-related requests.
 * This class provides endpoints for testing purposes.
 */
@RestController
@RequestMapping("/api/test")
public class TestController {
    /**
     * Public endpoint that returns a simple message.
     *
     * @return a string message indicating this is a public endpoint
     */
    @GetMapping("/public")
    public String publicEndpoint() {
        return "Este es un endpoint público.";
    }
}