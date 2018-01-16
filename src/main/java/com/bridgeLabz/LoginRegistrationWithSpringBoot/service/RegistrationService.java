package com.bridgeLabz.LoginRegistrationWithSpringBoot.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgeLabz.LoginRegistrationWithSpringBoot.model.User;
import com.bridgeLabz.LoginRegistrationWithSpringBoot.repository.UserRepository;

@Service
public class RegistrationService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User addUser(User user){
		
		User userForCheck = userRepository.findByUserName(user.getUserName());
		if(userForCheck==null){
			User userForReturn = userRepository.save(user);
			if(userForReturn!=null){
				return userForReturn;
			}
			return null;
		}
		return null;
	}
}
