package com.campusdual.amazing_store.api;

import com.campusdual.amazing_store.model.dto.ProductDTO;

import java.util.List;

public interface IProductService {
    //CRUD Operations
    ProductDTO queryProduct(ProductDTO productDTO);

    List<ProductDTO> queryAllProducts();

    int insertProduct(ProductDTO productDTO);

    int updateProduct(ProductDTO productDTO);

    int deleteProduct(ProductDTO productDTO);


   /* @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Object[]> getFilteredProductsAndContactsByType(String type) {
        Query query = entityManager.createNativeQuery(
                "SELECT p.*, c.* FROM productos p LEFT JOIN contactos c ON p.id = c.product_id WHERE p.product_type =? AND c.product_type =?",
                Object[].class);
        query.setParameter(1, type);
        query.setParameter(2, type);
        return query.getResultList();
    }
}*/

    // Nuevo método para obtener productos y contactos filtrados por tipo
    List<Object[]> getFilteredProductsAndContactsByType(String type);


}
