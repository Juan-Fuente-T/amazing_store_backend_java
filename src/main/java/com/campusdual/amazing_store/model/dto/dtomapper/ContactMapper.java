package com.campusdual.amazing_store.model.dto.dtomapper;

import com.campusdual.amazing_store.model.Contact;
import com.campusdual.amazing_store.model.dto.ContactDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;


@Mapper
public interface ContactMapper {
    /**
     * Singleton instance of the {@link ContactMapper}. This instance is intended to be used throughout the application
     * to ensure consistent mapping behavior across different components. The instance is automatically initialized
     * by MapStruct upon application startup and does not require explicit calls to obtain it.
     */
    ContactMapper INSTANCE = Mappers.getMapper(ContactMapper.class);
    /**
     * Converts a {@link Contact} entity to its corresponding {@link ContactDTO} representation.
     * This method is useful for transferring data from the domain model to the DTO layer,
     * typically used in service layers to prepare data for external clients or APIs.
     *
     * @param contact The {@link Contact} entity to convert.
     * @return The {@link ContactDTO} representation of the given {@link Contact} entity.
     */

    ContactDTO toDTO(Contact contact);
    /**
     * Converts a {@link ContactDTO} to its corresponding {@link Contact} entity.
     * This method is useful for converting incoming data (e.g., from API requests)
     * into domain entities suitable for business logic processing.
     *
     * @param contactdto The {@link ContactDTO} to convert.
     * @return The {@link Contact} entity representation of the given {@link ContactDTO}.
     */
    Contact toEntity(ContactDTO contactdto);
    /**
     * Converts a list of {@link Contact} entities to a list of their corresponding {@link ContactDTO} representations.
     * This method is particularly useful when dealing with collections of entities,
     * allowing for batch conversion to DTOs for bulk operations like exporting data.
     *
     * @param contacts The list of {@link Contact} entities to convert.
     * @return A list of {@link ContactDTO} representations of the given {@link Contact} entities.
     */
    List<ContactDTO> toDTOList(List<Contact> contacts);
}
