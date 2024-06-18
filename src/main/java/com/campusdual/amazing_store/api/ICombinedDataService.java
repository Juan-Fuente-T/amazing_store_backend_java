package com.campusdual.amazing_store.api;

import com.campusdual.amazing_store.model.dto.CombinedDTO;
import java.util.List;
/**
 * Interface defining operations for retrieving combined data between contacts and products.
 * This interface provides methods to fetch lists of combined DTOs that represent
 * relationships or associations between contacts and products within the system.
 */
public interface ICombinedDataService {
    /**
     * Retrieves a list of {@link CombinedDTO} objects that represent associations
     * between contacts and products. Each {@code CombinedDTO} contains information
     * about both a contact and one or more associated products.
     *
     * @return A list of {@code CombinedDTO} objects representing the associations
     *         between contacts and products.
     */
    List<CombinedDTO> getContactProducts();
}
