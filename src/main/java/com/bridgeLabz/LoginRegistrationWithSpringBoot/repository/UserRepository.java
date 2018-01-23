package com.bridgeLabz.LoginRegistrationWithSpringBoot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bridgeLabz.LoginRegistrationWithSpringBoot.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

	User findByUserName(String userName);

	User findById(int id);

}
