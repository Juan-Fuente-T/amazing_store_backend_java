package com.campusdual.amazing_store.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="products")
//@Table(name = "\"PRODUCTS\"")

public class Product {
    /**
     * Unique identifier for the product.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Name of the product.
     */
    @Column
    private String name;
    /**
     * Stock quantity available for the product.
     */
    @Column
    private int stock;

    /**
     * Price of the product.
     */
    @Column
    private BigDecimal price;
    /**
     * Indicates if the product is currently active.
     */
    @Column
    private boolean active;
    /**
     * Date when the product was added.
     */
    @Column
    private Date date_added;

    /**
     * Type of product.
     */
    @Column
    private String product_type;

    /**
     * ID of the contact associated with the product.
     */
    @Column
    private int contact_id;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getDate_added() {
        return date_added;
    }

    public void setDate_added(Date date_added) {
        this.date_added = date_added;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public int getContact_id() { return contact_id; }

    public void setContact_id(int contact_id) {
        this.contact_id = contact_id;
    }
}
