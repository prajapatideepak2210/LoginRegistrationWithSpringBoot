package com.bridgeLabz.LoginRegistrationWithSpringBoot;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
public class LoginTest {
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	/*@InjectMocks
	private LoginController loginController;*/
	
	private MockMvc mockMvc;
	
	@Before
	public void	setup(){
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	//@Ignore
	public void loginSuccessTest() throws Exception{
		User user = new User();
		user.setUserName("deepak@gmail.com");
		user.setPassword("12345678");
		mockMvc.perform(MockMvcRequestBuilders.post("/login").contentType(MediaType.APPLICATION_JSON).
				content(jsonObject(user))).andExpect(status().isAccepted()).andDo(print());
		
		/*System.out.println("kzdsjghdkanvksadbdv  : : "+response);
		int staus = response.getStatus();
		System.out.println("test status : "+staus);*/
	}
	
	private String jsonObject(User user) throws JsonProcessingException{
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = null;
		jsonString = mapper.writeValueAsString(user);
		return jsonString;
	}
	
	@Test
	//@Ignore
	public void loginFailTest() throws Exception{
		
		User user = new User();
		user.setUserName("aksh@gmail.com");
		user.setPassword("123456");
		mockMvc.perform(MockMvcRequestBuilders.post("/login").contentType(MediaType.APPLICATION_JSON).content(jsonObject(user)))
		.andExpect(status().isBadRequest()).andDo(print());
	}
	
}
