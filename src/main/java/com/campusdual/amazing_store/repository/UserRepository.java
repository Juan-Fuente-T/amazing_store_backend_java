package com.campusdual.amazing_store.repository;

import com.campusdual.amazing_store.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}