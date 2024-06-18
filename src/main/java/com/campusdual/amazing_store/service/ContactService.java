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

@Service("ContactService")
@Lazy
public class ContactService implements IContactService {
    @Autowired
    private ContactDao contactDao;

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

    @Override
    @Transactional
    public List<ContactDTO> queryAllContacts() {
        //Esta es la forma extendida
//        List<Contact> listaEntidadesContacto = contactDao.findAll();
//        List<ContactDTO> listaPojosContacto = ContactMapper.INSTANCE.toDTOList(listaEntidadesContacto);
//        return listaPojosContacto;
        return ContactMapper.INSTANCE.toDTOList(contactDao.findAll());
    }

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

    @Override
    @Transactional
    public int updateContact(ContactDTO contactDTO) {
        //seria aconsejable un is else para evaluar que no haya no intentar actualizar sin enviar un id
        return insertContact(contactDTO);//saveAndFlush inserta si no existe y actualiza si ya existe con un id
    }

    @Override
    @Transactional
    public int deleteContact(ContactDTO contactDTO) {
        int id = contactDTO.getId();
        contactDao.delete(ContactMapper.INSTANCE.toEntity(contactDTO));
        return id;
    }
}
