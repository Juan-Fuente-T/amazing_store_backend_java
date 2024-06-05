package com.campusdual.amazing_store.model.dao;

import com.campusdual.amazing_store.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactDao extends JpaRepository<Contact, Integer> {

}
