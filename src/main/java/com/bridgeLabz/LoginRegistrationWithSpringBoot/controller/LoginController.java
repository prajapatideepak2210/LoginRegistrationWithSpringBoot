package com.bridgeLabz.LoginRegistrationWithSpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bridgeLabz.LoginRegistrationWithSpringBoot.model.Response;
import com.bridgeLabz.LoginRegistrationWithSpringBoot.model.User;
import com.bridgeLabz.LoginRegistrationWithSpringBoot.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ResponseEntity<Response> login(@RequestBody User user){
		Response response = new Response();
		User userForCheck = loginService.login(user);
		if(userForCheck!=null){
			response.setResponseMessage("User successfully logedin.");
			System.out.println(response);
			return new ResponseEntity<Response>(response, HttpStatus.ACCEPTED);
		}
		response.setResponseMessage("User is not logedin.");
		return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
	}

}
