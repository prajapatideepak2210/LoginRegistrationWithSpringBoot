package com.bridgeLabz.LoginRegistrationWithSpringBoot;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bridgeLabz.LoginRegistrationWithSpringBoot.controller.LoginController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginRegistrationWithSpringBootApplicationTests {

	@Autowired
	LoginController loginController;
	
	
	@Test
	public void contextLoads() {
		
	}

}
