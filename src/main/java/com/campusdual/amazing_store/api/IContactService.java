package com.campusdual.amazing_store.api;

import com.campusdual.amazing_store.model.dto.ContactDTO;

import java.util.List;

/**
 * Interface defining operations for managing contacts in the system.
 * This includes CRUD operations such as querying, inserting, updating,
 * and deleting contacts.
 */
public interface IContactService {
    //CRUD Operations
    /**
     * Queries a single contact based on the provided {@link ContactDTO}.
     * Returns the matching {@code ContactDTO} if found, otherwise null.
     *
     * @param contactDTO The {@link ContactDTO} object containing the criteria for the query.
     * @return The {@code ContactDTO} object representing the queried contact, or null if not found.
     */
    ContactDTO queryContact(ContactDTO contactDTO);

    /**
     * Retrieves a list of all {@link ContactDTO} objects stored in the system.
     * This method does not take any parameters.
     *
     * @return A list of {@code ContactDTO} objects representing all contacts.
     */
    List<ContactDTO> queryAllContacts();
    /**
     * Inserts a new contact into the system using the provided {@link ContactDTO}.
     * Returns the ID of the newly inserted contact.
     *
     * @param contactDTO The {@link ContactDTO} object containing the details of the new contact.
     * @return The ID of the newly inserted contact.
     */
    int insertContact(ContactDTO contactDTO);
    /**
     * Updates an existing contact in the system using the provided {@link ContactDTO}.
     * Returns the number of rows affected by the update operation.
     *
     * @param contactDTO The {@link ContactDTO} object containing the updated details of the contact.
     * @return The number of rows affected by the update operation.
     */
    int updateContact(ContactDTO contactDTO);
    /**
     * Deletes a contact from the system based on the provided {@link ContactDTO}.
     * Returns the number of rows deleted by the operation.
     *
     * @param contactDTO The {@link ContactDTO} object identifying the contact to be deleted.
     * @return The number of rows deleted by the operation.
     */
    int deleteContact(ContactDTO contactDTO);
}
