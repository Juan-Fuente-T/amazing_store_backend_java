package com.campusdual.amazing_store.service;

import java.util.List;

import com.campusdual.amazing_store.api.IProductService;
import com.campusdual.amazing_store.model.Product;
import com.campusdual.amazing_store.model.dto.ProductDTO;
import com.campusdual.amazing_store.model.dto.dtomapper.ProductMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import com.campusdual.amazing_store.model.dao.ProductDao;

@Service("ProductService")
@Lazy
public class ProductService implements IProductService {

    @Autowired
    private ProductDao productDao;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ProductDTO queryProduct(ProductDTO productDTO) {
        Product product = ProductMapper.INSTANCE.toEntity(productDTO);
        return ProductMapper.INSTANCE.toDTO(productDao.getReferenceById(product.getId()));
// Esta es la forma extendida del mismo return
//        int id = product.getId(); //el id del producto del que queremos info
//        Product productoEntidad = productDao.getReferenceById(id);
//        ProductDTO productPojo = ProductMapper.INSTANCE.toDTO(productoEntidad);
//        return productPojo;
    }

    @Override
    public List<ProductDTO> queryAllProducts() {
        //Esta es la forma extendida
//        List<Product> listaEntidadesProducto = productDao.findAll();
//        List<ProductDTO> listaPojosProducto = ProductMapper.INSTANCE.toDTOList(listaEntidadesProducto);
//        return listaPojosProducto;
        return ProductMapper.INSTANCE.toDTOList(productDao.findAll());
    }

    @Override
    public int insertProduct(ProductDTO productDTO) {
        //Esta es la forma ectendida
//        Product entidadProducto = ProductMapper.INSTANCE.toEntity(productDTO);//Entidad sin ID
//        productDao.saveAndFlush(entidadProducto);//al insertar en DB se genra un nuevo ude para ese registro nuevo
//        //eL Flush recupera el id generado y se lo añade a la entidad
//        int idDeLaEntidad = entidadProducto.getId();
//        return idDeLaEntidad;
        Product product = ProductMapper.INSTANCE.toEntity(productDTO);
        productDao.saveAndFlush(product);//saveAndFlush inserta si no existe y actualiza si ya existe

        return product.getId();
    }

    @Override
    public int updateProduct(ProductDTO productDTO) {
        //seria aconsejable un is else para evaluar que no haya no intentar actualizar sin enviar un id
        return insertProduct(productDTO);//saveAndFlush inserta si no existe y actualiza si ya existe con un id
    }

    @Override
    public int deleteProduct(ProductDTO productDTO) {
        int id = productDTO.getId();
        productDao.delete(ProductMapper.INSTANCE.toEntity(productDTO));
        return id;
    }
    @Override
    public List<Object[]> getFilteredProductsAndContactsByType(String type) {
        Query query = entityManager.createNativeQuery(
                "SELECT DISTINCT p.NAME, p.STOCK FROM PRODUCTS p INNER JOIN CONTACTS c ON p.PRODUCT_TYPE = c.PRODUCT_TYPE WHERE p.PRODUCT_TYPE =?",
                Object[].class); // Solo un parámetro para el tipo de retorno
        query.setParameter(1, type);
        return query.getResultList();
    }
}
