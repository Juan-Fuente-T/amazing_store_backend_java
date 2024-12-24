package com.campusdual.amazing_store.api;
/**
 * Represents a login request containing the user's credentials.
 */
public class LoginRequest {

    private String username;
    private String password;
    /**
     * Retrieves the username for authentication.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }
    /**
     * Retrieves the password for authentication.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }
}