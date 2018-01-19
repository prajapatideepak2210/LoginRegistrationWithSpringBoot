package com.bridgeLabz.LoginRegistrationWithSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgeLabz.LoginRegistrationWithSpringBoot.model.User;
import com.bridgeLabz.LoginRegistrationWithSpringBoot.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User getUserById(int userId) {
		return userRepository.findByUserId(userId);
	}
	
	public User getUserByUserName(String userName){
		return userRepository.findByUserName(userName);
	}
	
	public List<User> getAllUser(){
		return (List<User>) userRepository.findAll();
	}
	
}
