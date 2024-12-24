package com.campusdual.amazing_store.service;

import com.campusdual.amazing_store.api.ICombinedDataService;
import com.campusdual.amazing_store.model.dto.CombinedDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * Service class for combining contact and product data.
 */
@Service("CombinedDataService")
@Lazy
public class CombinedDataService implements ICombinedDataService {

    @PersistenceContext
    private EntityManager entityManager;
    /**
     * Retrieves a list of contacts and their associated products.
     *
     * @return a list of CombinedDTO objects containing contact and product information
     */
    @Override
    @Transactional
    public List<CombinedDTO> getContactProducts() {
        Query query = entityManager.createNativeQuery(
                "SELECT DISTINCT c.NAME, c.SURNAME, p.NAME AS PRODUCT_NAME, p.STOCK " +
                        "FROM PRODUCTS p INNER JOIN CONTACTS c ON p.PRODUCT_TYPE = c.PRODUCT_TYPE " +
                        "WHERE c.ID = p.CONTACT_ID " +
                        "GROUP BY c.NAME, c.SURNAME, p.NAME, p.STOCK"
        );


        List<Object[]> results = query.getResultList();
        List<CombinedDTO> combinedDTOList = new ArrayList<>();

        for (Object[] result : results) {
            CombinedDTO combinedDTO = new CombinedDTO();
            combinedDTO.setContactName((String) result[0]);
            combinedDTO.setContactSurname((String) result[1]);
            combinedDTO.setProductName((String) result[2]);
            combinedDTO.setProductStock((Integer) result[3]);
            combinedDTOList.add(combinedDTO);
        }

        return combinedDTOList;
    }
}
