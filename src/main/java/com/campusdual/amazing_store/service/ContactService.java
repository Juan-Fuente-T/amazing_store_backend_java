package com.campusdual.amazing_store.service;

import com.campusdual.amazing_store.api.IContactService;
import com.campusdual.amazing_store.model.Contact;
import com.campusdual.amazing_store.model.dao.ContactDao;
import com.campusdual.amazing_store.model.dto.ContactDTO;
import com.campusdual.amazing_store.model.dto.dtomapper.ContactMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class responsible for handling operations related to contacts in the amazing store system.
 * Implements the IProductService interface to provide CRUD operations and queries for contacts.
 */
@Service("ContactService")
@Lazy
public class ContactService implements IContactService {
    @Autowired
    private ContactDao contactDao;

    /**
     * Queries a contact by its DTO representation and returns its detailed information.
     * Converts the DTO to an entity, retrieves the product from the database, and then converts it back to a DTO.
     *
     * @param contactDTO The DTO representing the contact to query.
     * @return The detailed information of the queried contact as a DTO.
     */
    @Override
    @Transactional
    public ContactDTO queryContact(ContactDTO contactDTO) {
        Contact contact = ContactMapper.INSTANCE.toEntity(contactDTO);
        return ContactMapper.INSTANCE.toDTO(contactDao.getReferenceById(contact.getId()));
// Esta es la forma extendida del mismo return
//        int id = contact.getId(); //el id del producto del que queremos info
//        Contact contactoEntidad = contactDao.getReferenceById(id);
//        ContactDTO contactPojo = ContactMapper.INSTANCE.toDTO(contactoEntidad);
//        return contactPojo;
    }

    /**
     * Retrieves all contacts available in the system.
     * Converts the list of entities retrieved from the database to a list of DTOs.
     *
     * @return A list of DTOs representing all contacts.
     */
    @Override
    @Transactional
    public List<ContactDTO> queryAllContacts() {
        //Esta es la forma extendida
//        List<Contact> listaEntidadesContacto = contactDao.findAll();
//        List<ContactDTO> listaPojosContacto = ContactMapper.INSTANCE.toDTOList(listaEntidadesContacto);
//        return listaPojosContacto;
        return ContactMapper.INSTANCE.toDTOList(contactDao.findAll());
    }

    /**
     * Inserts a new contact into the database using the provided DTO.
     * Converts the DTO to an entity, saves it to the database, and returns the generated ID.
     *
     * @param contactDTO The DTO representing the contact to insert.
     * @return The ID of the newly inserted contact.
     */
    @Override
    @Transactional
    public int insertContact(ContactDTO contactDTO) {
        //Esta es la forma extendida
//        Contact entidadContacto = ContactMapper.INSTANCE.toEntity(contactDTO);//Entidad sin ID
//        contactDao.saveAndFlush(entidadContacto);//al insertar en DB se genra un nuevo ude para ese registro nuevo
//        //eL Flush recupera el id generado y se lo añade a la entidad
//        int idDeLaEntidad = entidadContacto.getId();
//        return idDeLaEntidad;
        Contact contact = ContactMapper.INSTANCE.toEntity(contactDTO);
        contactDao.saveAndFlush(contact);//saveAndFlush inserta si no existe y actualiza si ya existe

        return contact.getId();
    }

    /**
     * Updates an existing contact in the database using the provided DTO.
     * Converts the DTO to an entity and saves it to the database.
     * Note: This method uses the insertContacct method internally.
     *
     * @param contactDTO The DTO representing the contact to update.
     * @return The ID of the updated contact.
     */
    @Override
    @Transactional
    public int updateContact(ContactDTO contactDTO) {
        //seria aconsejable un is else para evaluar que no haya no intentar actualizar sin enviar un id
        return insertContact(contactDTO);//saveAndFlush inserta si no existe y actualiza si ya existe con un id
    }

    /**
     * Deletes a contact from the database using the provided DTO.
     * Converts the DTO to an entity and deletes it from the database.
     * Returns the ID of the deleted product.
     *
     * @param contactDTO The DTO representing the contact to delete.
     * @return The ID of the deleted contact.
     */
    @Override
    @Transactional
    public int deleteContact(ContactDTO contactDTO) {
        int id = contactDTO.getId();
        contactDao.delete(ContactMapper.INSTANCE.toEntity(contactDTO));
        return id;
    }
}
