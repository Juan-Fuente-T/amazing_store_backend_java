package com.campusdual.amazing_store.model.dto;

import com.campusdual.amazing_store.model.Contact;

/**
 * Data Transfer Object (DTO) for {@link Contact} entities.
 * Used to transfer contact data between subsystems or layers within the application.
 * This DTO includes basic contact information such as name, surname, telephone, city, email, and product type.
 */
public class ContactDTO {
    private int id;

    private String name;

    private String surname;

//    private String lastname;

    private String telephone;

    private String city;

    private String email;

    private String product_type;
    /**
     * Gets the unique identifier of the contact.
     *
     * @return The unique identifier of the contact.
     */
    public int getId() {
        return id;
    }
    /**
     * Sets the unique identifier of the contact.
     *
     * @param id The unique identifier of the contact.
     */

    public void setId(int id) {
        this.id = id;
    }
    /**
     * Gets the name of the contact.
     *
     * @return The name of the contact.
     */
    public String getName() {
        return name;
    }
    /**
     * Sets the name of the contact.
     *
     * @param name The name of the contact.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Gets the surname of the contact.
     *
     * @return The surname of the contact.
     */
    public String getSurname() {
        return surname;
    }
    /**
     * Sets the surname of the contact.
     *
     * @param surname The surname of the contact.
     */
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

    /**
     * Gets the telephone number of the contact.
     *
     * @return The telephone number of the contact.
     */
    public String getTelephone() {
        return telephone;
    }
    /**
     * Sets the telephone number of the contact.
     *
     * @param telephone The telephone number of the contact.
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    /**
     * Gets the city where the contact resides.
     *
     * @return The city where the contact resides.
     */
    public String getCity() {
        return city;
    }
    /**
     * Sets the city where the contact resides.
     *
     * @param city The city where the contact resides.
     */
    public void setCity (String city) {
        this.city = city;
    }
    /**
     * Gets the email address of the contact.
     *
     * @return The email address of the contact.
     */
    public String getEmail() {
        return email;
    }
    /**
     * Sets the email address of the contact.
     *
     * @param email The email address of the contact.
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Gets the product type associated with the contact.
     *
     * @return The product type associated with the contact.
     */
    public String getProduct_type() {
        return product_type;
    }
    /**
     * Sets the product type associated with the contact.
     *
     * @param product_type The product type associated with the contact.
     */
    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }
}
