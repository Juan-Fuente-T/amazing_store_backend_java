package com.campusdual.amazing_store.api;

import com.campusdual.amazing_store.model.dto.ProductDTO;

import java.util.List;
/**
 * Interface defining operations for managing products in the system.
 * This includes CRUD operations such as querying, inserting, updating,
 * and deleting products.
 */
public interface IProductService {

    /**
     * Queries a single product based on the provided {@link ProductDTO}.
     * Returns the matching {@code ProductDTO} if found, otherwise null.
     *
     * @param productDTO The {@link ProductDTO} object containing the criteria for the query.
     * @return The {@code ProductDTO} object representing the queried product, or null if not found.
     */
    ProductDTO queryProduct(ProductDTO productDTO);

    /**
     * Retrieves a list of all {@link ProductDTO} objects stored in the system.
     * This method does not take any parameters.
     *
     * @return A list of {@code ProductDTO} objects representing all products.
     */
    List<ProductDTO> queryAllProducts();

    /**
     * Inserts a new product into the system using the provided {@link ProductDTO}.
     * Returns the ID of the newly inserted product.
     *
     * @param productDTO The {@link ProductDTO} object containing the details of the new product.
     * @return The ID of the newly inserted product.
     */
    int insertProduct(ProductDTO productDTO);

    /**
     * Updates an existing product in the system using the provided {@link ProductDTO}.
     * Returns the number of rows affected by the update operation.
     *
     * @param productDTO The {@link ProductDTO} object containing the updated details of the product.
     * @return The number of rows affected by the update operation.
     */
    int updateProduct(ProductDTO productDTO);

    /**
     * Deletes a product from the system based on the provided {@link ProductDTO}.
     * Returns the number of rows deleted by the operation.
     *
     * @param productDTO The {@link ProductDTO} object identifying the product to be deleted.
     * @return The number of rows deleted by the operation.
     */
    int deleteProduct(ProductDTO productDTO);
}
