package com.campusdual.amazing_store.service;

import java.util.List;

import com.campusdual.amazing_store.api.IProductService;
import com.campusdual.amazing_store.model.Product;
import com.campusdual.amazing_store.model.dto.ProductDTO;
import com.campusdual.amazing_store.model.dto.dtomapper.ProductMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import com.campusdual.amazing_store.model.dao.ProductDao;
/**
 * Service class responsible for handling operations related to products in the amazing store system.
 * Implements the IProductService interface to provide CRUD operations and queries for products.
 */
@Service("ProductService")
@Lazy
public class ProductService implements IProductService {

    @Autowired
    private ProductDao productDao;

    @PersistenceContext
    private EntityManager entityManager;
    /**
     * Queries a product by its DTO representation and returns its detailed information.
     * Converts the DTO to an entity, retrieves the product from the database, and then converts it back to a DTO.
     *
     * @param productDTO The DTO representing the product to query.
     * @return The detailed information of the queried product as a DTO.
     */
    @Override
    @Transactional
    public ProductDTO queryProduct(ProductDTO productDTO) {
        Product product = ProductMapper.INSTANCE.toEntity(productDTO);
        return ProductMapper.INSTANCE.toDTO(productDao.getReferenceById(product.getId()));
// Esta es la forma extendida del mismo return
//        int id = product.getId(); //el id del producto del que queremos info
//        Product productoEntidad = productDao.getReferenceById(id);
//        ProductDTO productPojo = ProductMapper.INSTANCE.toDTO(productoEntidad);
//        return productPojo;
    }
    /**
     * Retrieves all products available in the system.
     * Converts the list of entities retrieved from the database to a list of DTOs.
     *
     * @return A list of DTOs representing all products.
     */
    @Override
    @Transactional
    public List<ProductDTO> queryAllProducts() {
        //Esta es la forma extendida
//        List<Product> listaEntidadesProducto = productDao.findAll();
//        List<ProductDTO> listaPojosProducto = ProductMapper.INSTANCE.toDTOList(listaEntidadesProducto);
//        return listaPojosProducto;
        return ProductMapper.INSTANCE.toDTOList(productDao.findAll());
    }
    /**
     * Inserts a new product into the database using the provided DTO.
     * Converts the DTO to an entity, saves it to the database, and returns the generated ID.
     *
     * @param productDTO The DTO representing the product to insert.
     * @return The ID of the newly inserted product.
     */
    @Override
    @Transactional
    public int insertProduct(ProductDTO productDTO) {
        //Esta es la forma ectendida
        Product entidadProducto = ProductMapper.INSTANCE.toEntity(productDTO);//Entidad sin ID
        productDao.saveAndFlush(entidadProducto);//al insertar en Database se genera un nuevo id para ese registro nuevo
        //eL Flush recupera el id generado y se lo añade a la entidad
        int idDeLaEntidad = entidadProducto.getId();
        return idDeLaEntidad;
//        Product product = ProductMapper.INSTANCE.toEntity(productDTO);
//        productDao.saveAndFlush(product);//saveAndFlush inserta si no existe y actualiza si ya existe
//
//        return product.getId();
    }
    /**
     * Updates an existing product in the database using the provided DTO.
     * Converts the DTO to an entity and saves it to the database.
     * Note: This method uses the insertProduct method internally.
     *
     * @param productDTO The DTO representing the product to update.
     * @return The ID of the updated product.
     */
    @Override
    @Transactional
    public int updateProduct(ProductDTO productDTO) {
        //seria aconsejable un is else para evaluar que no haya a intentar actualizar sin enviar un id
        return insertProduct(productDTO);//saveAndFlush inserta si no existe y actualiza si ya existe con un id
    }

    /**
     * Deletes a product from the database using the provided DTO.
     * Converts the DTO to an entity and deletes it from the database.
     * Returns the ID of the deleted product.
     *
     * @param productDTO The DTO representing the product to delete.
     * @return The ID of the deleted product.
     */
    @Override
    @Transactional
    public int deleteProduct(ProductDTO productDTO) {
        int id = productDTO.getId();
        productDao.delete(ProductMapper.INSTANCE.toEntity(productDTO));
        return id;
    }
}