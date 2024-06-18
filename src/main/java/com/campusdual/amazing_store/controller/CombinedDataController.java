package com.campusdual.amazing_store.controller;

import com.campusdual.amazing_store.model.dto.CombinedDTO;
import com.campusdual.amazing_store.service.CombinedDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Controller responsible for handling HTTP requests related to combined data
 * between contacts and products. It exposes endpoints to retrieve lists of
 * {@link CombinedDTO} objects that represent associations between contacts and
 * products within the system.
 */
@RestController
@RequestMapping("/combined-data")
public class CombinedDataController {

    @Autowired
    private CombinedDataService combinedDataService;
    /**
     * Endpoint to retrieve a list of {@link CombinedDTO} objects representing
     * associations between contacts and products. This method delegates the
     * retrieval logic to {@link CombinedDataService#getContactProducts()}.
     *
     * @return A list of {@code CombinedDTO} objects representing the associations
     *         between contacts and products.
     */
    @GetMapping("/contact-products")
    public List<CombinedDTO> getContactProducts() {
        return combinedDataService.getContactProducts();
    }
}
