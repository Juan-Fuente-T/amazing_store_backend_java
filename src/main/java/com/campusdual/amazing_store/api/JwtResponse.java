package com.campusdual.amazing_store.api;

/**
 * Represents the response containing the JWT token after successful authentication.
 */
public class JwtResponse {

    private String token;

    /**
     * Constructs a JwtResponse with the specified token.
     *
     * @param token the JWT token
     */
    public JwtResponse(String token) {
        this.token = token;
    }

    /**
     * Retrieves the JWT token.
     *
     * @return the JWT token
     */
    public String getToken() {
        return token;
    }
    /**
     * Sets the JWT token.
     *
     * @param token the JWT token to set
     */
    public void setToken(String token) {
        this.token = token;
    }
}