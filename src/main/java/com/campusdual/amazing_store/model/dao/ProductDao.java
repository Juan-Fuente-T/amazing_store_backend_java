package com.campusdual.amazing_store.model.dao;

import com.campusdual.amazing_store.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Integer> {

}
