package com.bridgeLabz.LoginRegistrationWithSpringBoot.repository;

import org.springframework.data.repository.CrudRepository;

import com.bridgeLabz.LoginRegistrationWithSpringBoot.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	User findByUserName(String userName);

	User findByUserId(int userId);

}
