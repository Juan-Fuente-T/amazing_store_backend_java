package com.campusdual.amazing_store.model.dao;

import com.campusdual.amazing_store.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Data Access Object (DAO) interface for the {@link Product} entity.
 * Extends {@link JpaRepository} to provide basic CRUD operations for the {@code Product} entity.
 * This interface allows for easy integration with Spring Data JPA repositories,
 * enabling the application to perform database operations on {@code Product} entities.
 */
public interface ProductDao extends JpaRepository<Product, Integer> {

}
