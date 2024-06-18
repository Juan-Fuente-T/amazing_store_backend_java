package com.campusdual.amazing_store.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Represents a contact within the amazing store system.
 * Contains basic information such as name, surname, telephone, city, email, and product type.
 * This entity is mapped to the "contacts" table in the database.
 */
@Entity
@Table(name="contacts")
//@Table(name = "\"CONTACTS\"")

public class Contact {
    /**
     * Unique identifier for the contact.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * Name of the contact.
     */
    @Column
    private String name;
    /**
     * Surname of the contact.
     */
    @Column
    private String surname;

//    @Column
//    private String lastname;

    /**
     * Telephone number of the contact.
     */
    @Column
    private String telephone;

    /**
     * City of the contact.
     */
  @Column
    private String city;
    /**
     * Email address of the contact.
     */
    @Column
    private String email;
    /**
     * Type of product associated with the contact.
     */

    // Getters and Setters
    @Column
    private String product_type;


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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

//    public String getLastname() {
//        return lastname;
//    }
//
//    public void setLastname(String lastname) {
//        this.lastname = lastname;
//    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }
}