package com.campusdual.amazing_store.model.dto;

import com.campusdual.amazing_store.model.Product;

import java.math.BigDecimal;
import java.util.Date;
/**
 * Data Transfer Object (DTO) for {@link Product} entities. Used to transfer product data between subsystems
 * and layers within the application, such as from the service layer to the controller layer or vice versa.
 * This DTO includes basic product information along with additional fields like {@code contact_id} and
 * {@code product_type} that may be specific to certain contexts or requirements.
 */
public class ProductDTO {

    private int id;

    private String name;

    private int stock;

    private BigDecimal price;

    private boolean active;

    private Date date_added;

    private String product_type;

    private int contact_id;

    /**
     * Gets the unique identifier of the product.
     *
     * @return The product's ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the product.
     *
     * @param id The product's ID.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name of the product.
     *
     * @return The product's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the product.
     *
     * @param name The product's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the current stock quantity of the product.
     *
     * @return The product's stock quantity.
     */
    public int getStock() {
        return stock;
    }

    /**
     * Sets the current stock quantity of the product.
     *
     * @param stock The product's stock quantity.
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Gets the price of the product.
     *
     * @return The product's price.
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets the price of the product.
     *
     * @param price The product's price.
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Indicates whether the product is currently active.
     *
     * @return True if the product is active, false otherwise.
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Sets the activation status of the product.
     *
     * @param active Whether the product is active.
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Gets the date the product was added.
     *
     * @return The date the product was added.
     */
    public Date getDate_added() {
        return date_added;
    }

    /**
     * Sets the date the product was added.
     *
     * @param date_added The date the product was added.
     */
    public void setDate_added(Date date_added) {
        this.date_added = date_added;
    }

    /**
     * Gets the type of the product.
     *
     * @return The type of the product.
     */
    public String getProduct_type() {
        return product_type;
    }

    /**
     * Sets the type of the product.
     *
     * @param product_type The type of the product.
     */
    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    /**
     * Gets the ID of the associated contact.
     *
     * @return The ID of the associated contact.
     */
    public int getContact_id() {
        return contact_id;
    }

    /**
     * Sets the ID of the associated contact.
     *
     * @param contact_id The ID of the associated contact.
     */
    public void setContact_id(int contact_id) {
        this.contact_id = contact_id;
    }
}
