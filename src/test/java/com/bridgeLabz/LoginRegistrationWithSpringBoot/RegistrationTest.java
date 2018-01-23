package com.bridgeLabz.LoginRegistrationWithSpringBoot;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.bridgeLabz.LoginRegistrationWithSpringBoot.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebAppConfiguration
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RegistrationTest {

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;
	
	@Before
	public void	setup(){
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	@Ignore
	public void registrationTest() throws Exception{
		User user = new User();
		user.setName("deepak");
		user.setUserName("deepak@gmail.com");
		user.setPassword("12345678");
		user.setContactNumber("8759645852");
		mockMvc.perform(MockMvcRequestBuilders.post("/registration").contentType(MediaType.APPLICATION_JSON)
				.content(jsonObject(user))).andExpect(status().isOk()).andDo(print());
	}
	
	private String jsonObject(User user) throws JsonProcessingException{
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = null;
		jsonString = mapper.writeValueAsString(user);
		return jsonString;
	}
	
	@Test
	@Ignore
	public void registrationFailTest() throws Exception{
		User user = new User();
		user.setName("deepak");
		mockMvc.perform(MockMvcRequestBuilders.post("/registration").contentType(MediaType.APPLICATION_JSON)
				.content(jsonObject(user))).andExpect(status().isInternalServerError()).andDo(print());
	}
	
	@Test
	@Ignore
	public void UserAlredyExistTest() throws JsonProcessingException, Exception{
		User user = new User();
		user.setUserName("s@gmail.com");
		user.setContactNumber("9745982735");
		user.setName("deepak");
		user.setPassword("deepak12");
		mockMvc.perform(MockMvcRequestBuilders.post("/registration").contentType(MediaType.APPLICATION_JSON)
				.content(jsonObject(user))).andExpect(status().isBadRequest()).andDo(print());
	}
	
	@Test
	@Ignore
	public void validationPasswordTest() throws JsonProcessingException, Exception{
		User user = new User();
		user.setName("deepak");
		user.setUserName("deepak@gmail");
		user.setPassword("12365");
		user.setContactNumber("84845555513");
		mockMvc.perform(MockMvcRequestBuilders.post("/registration").contentType(MediaType.APPLICATION_JSON)
				.content(jsonObject(user))).andExpect(status().isNotAcceptable()).andDo(print())
				.andExpect(jsonPath("$.responseMessage", Matchers.is("Password is not correct.")));
	}
	
}
