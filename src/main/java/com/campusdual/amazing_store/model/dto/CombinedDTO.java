package com.campusdual.amazing_store.model.dto;

/**
 * Combined Data Transfer Object (DTO) that encapsulates both contact and product information.
 * This DTO is designed to carry combined data from both a contact and a product entity,
 * facilitating operations that require information from both domains.
 */
public class CombinedDTO {
    private String contactName;
    private String contactSurname;
    private String productName;
    private int productStock;
    /**
     * Gets the name of the contact associated with this DTO.
     *
     * @return The name of the contact.
     */
    public String getContactName() {
        return contactName;
    }
    /**
     * Sets the name of the contact associated with this DTO.
     *
     * @param contactName The new name of the contact.
     */
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
    /**
     * Gets the surname of the contact associated with this DTO.
     *
     * @return The surname of the contact.
     */
    public String getContactSurname() {
        return contactSurname;
    }
    /**
     * Sets the surname of the contact associated with this DTO.
     *
     * @param contactSurname The new surname of the contact.
     */
    public void setContactSurname(String contactSurname) {
        this.contactSurname = contactSurname;
    }
    /**
     * Gets the name of the product associated with this DTO.
     *
     * @return The name of the product.
     */
    public String getProductName() {
        return productName;
    }
    /**
     * Sets the name of the product associated with this DTO.
     *
     * @param productName The new name of the product.
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }
    /**
     * Gets the stock quantity of the product associated with this DTO.
     *
     * @return The stock quantity of the product.
     */
    public int getProductStock() {
        return productStock;
    }

    /**
     * Sets the stock quantity of the product associated with this DTO.
     *
     * @param productStock The new stock quantity of the product.
     */
    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }
}
