package com.campusdual.amazing_store.model.dao;

import com.campusdual.amazing_store.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Data Access Object (DAO) interface for the {@link Contact} entity.
 * Extends {@link JpaRepository} to provide basic CRUD operations for the {@code Contact} entity.
 * This interface allows for easy integration with Spring Data JPA repositories,
 * enabling the application to perform database operations on {@code Contact} entities.
 */
public interface ContactDao extends JpaRepository<Contact, Integer> {

}
