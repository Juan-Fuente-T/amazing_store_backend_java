package com.campusdual.amazing_store.model.dto;

public class CombinedDTO {


    private ContactDTO contactInfo;
    private ProductDTO productInfo;

    // Constructor vacío para serialización/deserialización con Jackson
    public CombinedDTO() {}

    // Constructor con parámetros para inicialización manual
    public CombinedDTO(ContactDTO contactInfo, ProductDTO productInfo) {
        this.contactInfo = contactInfo;
        this.productInfo = productInfo;
    }

    // Getters y Setters
    public ContactDTO getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactDTO contactInfo) {
        this.contactInfo = contactInfo;
    }

    public ProductDTO getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(ProductDTO productInfo) {
        this.productInfo = productInfo;
    }
}
