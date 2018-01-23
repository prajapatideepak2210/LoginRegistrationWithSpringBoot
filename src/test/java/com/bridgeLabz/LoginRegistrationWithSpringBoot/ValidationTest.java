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

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ValidationTest {
	@Autowired
	private WebApplicationContext webApplicationContext; 
	
	private MockMvc mockMvc;
	
	@Before
	public void setup(){
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	private String jsonObject(User user) throws JsonProcessingException{
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = null;
		jsonString = mapper.writeValueAsString(user);
		return jsonString;
	}
	
	@Test
	@Ignore
	public void validationNameTest() throws Exception{
		User user = new User();
		user.setName("deepak565");
		user.setUserName("deepak@gmail.com");
		user.setPassword("12365");
		user.setContactNumber("84845555513");
		mockMvc.perform(MockMvcRequestBuilders.post("/registration").contentType(MediaType.APPLICATION_JSON)
				.content(jsonObject(user))).andExpect(status().isNotAcceptable()).andDo(print())
				.andExpect(jsonPath("$.responseMessage", Matchers.is("Name is not correct.")));
	}
	
	@Test
	@Ignore
	public void validationUserNameTest() throws JsonProcessingException, Exception{
		User user = new User();
		user.setName("deepak");
		user.setUserName("deepak@gmail");
		user.setPassword("12365457");
		user.setContactNumber("8484555551");
		mockMvc.perform(MockMvcRequestBuilders.post("/registration").contentType(MediaType.APPLICATION_JSON)
				.content(jsonObject(user))).andExpect(status().isNotAcceptable()).andDo(print())
				.andExpect(jsonPath("$.responseMessage", Matchers.is("UserName is not correct.")));
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
	
	@Test
	@Ignore
	public void validationContactNumberTest() throws JsonProcessingException, Exception{
		User user = new User();
		user.setName("deepak");
		user.setUserName("deepak@gmail.com");
		user.setPassword("1e3s5p78");
		user.setContactNumber("84845555513457");
		mockMvc.perform(MockMvcRequestBuilders.post("/registration").contentType(MediaType.APPLICATION_JSON)
				.content(jsonObject(user))).andExpect(status().isNotAcceptable()).andDo(print())
				.andExpect(jsonPath("$.responseMessage", Matchers.is("Contact Number is not correct.")));
	}
	
}
