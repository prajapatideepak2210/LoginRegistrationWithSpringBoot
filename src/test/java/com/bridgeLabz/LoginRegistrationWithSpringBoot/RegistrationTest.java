package com.bridgeLabz.LoginRegistrationWithSpringBoot;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.bridgeLabz.LoginRegistrationWithSpringBoot.LoginRegistrationWithSpringBootApplicationTests;
import com.bridgeLabz.LoginRegistrationWithSpringBoot.controller.RegistrationController;
import com.bridgeLabz.LoginRegistrationWithSpringBoot.model.User;
import com.bridgeLabz.LoginRegistrationWithSpringBoot.service.RegistrationService;

import ch.qos.logback.core.status.Status;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RegistrationTest {

	@InjectMocks
	RegistrationController registrationController;

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mvc;

	@org.junit.Before
	public void setUp() {
		this.mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	@Ignore
	public void LoginTest() {
		User user = new User();
		user.setUserName("akash@gmail.com");
		user.setPassword("123456");
		System.out.println(registrationController);
		try {
			this.mvc.perform(MockMvcRequestBuilders.post("/login").contentType(MediaType.APPLICATION_JSON)
					.content(jsonObject(user))).andExpect(status().isAccepted()).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void loginFailTest() throws Exception {
		User user = new User();
		user.setUserName("imterdal@gmail.com");
		user.setPassword("quuiyurweqrw");
		this.mvc.perform(MockMvcRequestBuilders.post("/login").contentType(MediaType.APPLICATION_JSON)
				.content(jsonObject(user))).andExpect(status().isBadRequest()).andDo(print());
	}

	private String jsonObject(User employee) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = null;
		try {
			jsonString = mapper.writeValueAsString(employee);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonString;
	}

	/*@Test
	public void testRegisterEmployee() throws Exception {
		Employee employee = new Employee();
		employee.setEmpName("AdamVoges");
		employee.setEmail("voges@gmail.com");
		employee.setPassword("qwertyio");
		employee.setPhone("7856748756");
		this.mvc.perform(MockMvcRequestBuilders.post("/register").contentType(MediaType.APPLICATION_JSON)
				.content(jsonObject(employee))).andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testRegisterExsists() throws Exception {
		Employee employee = new Employee();
		employee.setEmpName("Imran khan");
		employee.setEmail("imterdal@gmail.com");
		employee.setPassword("qwertyuio");
		employee.setPhone("8978678978");
		this.mvc.perform(MockMvcRequestBuilders.post("/register").contentType(MediaType.APPLICATION_JSON)
				.content(jsonObject(employee))).andExpect(status().isOk()).andDo(print());
	}
*/

}
