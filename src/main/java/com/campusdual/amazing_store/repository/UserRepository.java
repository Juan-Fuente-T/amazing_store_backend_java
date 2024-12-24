package com.campusdual.amazing_store.repository;

import com.campusdual.amazing_store.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Repository interface for accessing User entities.
 * Extends JpaRepository to provide CRUD operations and custom query methods.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Finds a User by their username.
     *
     * @param username the username of the User to find
     * @return the User associated with the given username, or null if no User is found
     */
    User findByUsername(String username);

}