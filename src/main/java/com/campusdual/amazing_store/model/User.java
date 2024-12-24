package com.campusdual.amazing_store.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    /**
     * Unique identifier for the user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Name of the user.
     */
    @Column(unique = true, nullable = false)
    private String username;
    /**
     * Password of the user.
     */
    @Column(nullable = false)
    private String password;
    /**
     * Role of the user.
     */
    @Column(nullable = false)
    private String role; // Por ejemplo: "user", "admin"
    /**
     * Retrieves the password of the user.
     *
     * @return the password of the user.
     */
    public String getPassword() {
        return password;
    }
}
