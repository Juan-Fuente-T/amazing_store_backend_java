package com.campusdual.amazing_store.api;

import com.campusdual.amazing_store.model.dto.ContactDTO;

import java.util.List;

public interface IContactService {
    //CRUD Operations
    ContactDTO queryContact(ContactDTO contactDTO);

    List<ContactDTO> queryAllContacts();

    int insertContact(ContactDTO contactDTO);

    int updateContact(ContactDTO contactDTO);

    int deleteContact(ContactDTO contactDTO);
}
