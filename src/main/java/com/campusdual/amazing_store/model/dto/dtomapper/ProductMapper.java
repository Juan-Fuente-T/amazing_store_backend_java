package com.campusdual.amazing_store.model.dto.dtomapper;

import com.campusdual.amazing_store.model.Product;
import com.campusdual.amazing_store.model.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    ProductDTO toDTO(Product product);
    Product toEntity(ProductDTO productdto);
    List<ProductDTO> toDTOList(List<Product> products);
}
