package com.bridgeLabz.LoginRegistrationWithSpringBoot.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bridgeLabz.LoginRegistrationWithSpringBoot.model.User;
import com.bridgeLabz.LoginRegistrationWithSpringBoot.repository.UserRepository;

@Service
public class RegistrationService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public User addUser(User user){
			User userForCheck = userRepository.findByUserName(user.getUserName());
			if(userForCheck==null){
				return userRepository.save(user);
			}
			return null;
	}

}
