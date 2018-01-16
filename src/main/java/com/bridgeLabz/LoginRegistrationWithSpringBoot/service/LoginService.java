package com.bridgeLabz.LoginRegistrationWithSpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgeLabz.LoginRegistrationWithSpringBoot.model.User;
import com.bridgeLabz.LoginRegistrationWithSpringBoot.repository.UserRepository;

@Service
public class LoginService {

	@Autowired
	private UserRepository userRepository;

	public User login(User loginUser){
		if(loginUser==null){
			System.out.println("kjasdfjasbfsjbfsjfs,dfasmfgasmfsjadfvbsfvb,msvhfnabs v");
			return null;
		}
		User userForCheck = userRepository.findByUserName(loginUser.getUserName());

		if(userForCheck!=null){
			if(userForCheck.getUserName().equals(loginUser.getUserName()) && 
					userForCheck.getPassword().equals(loginUser.getPassword())){
				return userForCheck;
			}
			return null;
		}
		return null;

	}

}
