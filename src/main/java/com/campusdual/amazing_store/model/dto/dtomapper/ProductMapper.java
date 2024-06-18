package com.campusdual.amazing_store.model.dto.dtomapper;

import com.campusdual.amazing_store.model.Product;
import com.campusdual.amazing_store.model.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {
    /**
     * Singleton instance of the {@link ProductMapper}. This instance is intended to be used throughout the application
     * to ensure consistent mapping behavior across different components. The instance is automatically initialized
     * by MapStruct upon application startup and does not require explicit calls to obtain it.
     */
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    /**
     * Converts a {@link Product} entity to its corresponding {@link ProductDTO} representation.
     * This method is useful for transferring data from the domain model to the DTO layer,
     * typically used in service layers to prepare data for external clients or APIs.
     *
     * @param product The {@link Product} entity to convert.
     * @return The {@link ProductDTO} representation of the given {@link Product} entity.
     */
    ProductDTO toDTO(Product product);
    /**
     * Converts a {@link ProductDTO} to its corresponding {@link Product} entity.
     * This method is useful for converting incoming data (e.g., from API requests)
     * into domain entities suitable for business logic processing.
     *
     * @param productdto The {@link ProductDTO} to convert.
     * @return The {@link Product} entity representation of the given {@link ProductDTO}.
     */
    Product toEntity(ProductDTO productdto);
    /**
     * Converts a list of {@link Product} entities to a list of their corresponding {@link ProductDTO} representations.
     * This method is particularly useful when dealing with collections of entities,
     * allowing for batch conversion to DTOs for bulk operations like exporting data.
     *
     * @param products The list of {@link Product} entities to convert.
     * @return A list of {@link ProductDTO} representations of the given {@link Product} entities.
     */
    List<ProductDTO> toDTOList(List<Product> products);
}
