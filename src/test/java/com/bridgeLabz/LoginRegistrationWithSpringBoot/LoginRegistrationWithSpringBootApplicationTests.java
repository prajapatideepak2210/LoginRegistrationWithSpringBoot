package com.bridgeLabz.LoginRegistrationWithSpringBoot;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import com.bridgeLabz.LoginRegistrationWithSpringBoot.controller.LoginController;
import com.bridgeLabz.LoginRegistrationWithSpringBoot.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginRegistrationWithSpringBootApplicationTests {

	@Autowired
	LoginController loginController;
	
	
	@Test
	public void contextLoads() {
		User user = new User();
		
			user.setUserName("deepak@gmail.com");
			user.setPassword("deepak12");
			
			assertEquals(HttpStatus.ACCEPTED,loginController.login(user));
		
	}

}
