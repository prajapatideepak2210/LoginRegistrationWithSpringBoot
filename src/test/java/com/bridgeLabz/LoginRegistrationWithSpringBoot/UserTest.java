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

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class UserTest {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	@Ignore
	public void getUserByIdSuccessTest() throws Exception {
		int id = 1;
		mockMvc.perform(MockMvcRequestBuilders.get("/getUserbyId/{id}", id).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isAccepted()).andDo(print());
	}
	
	@Test
	@Ignore
	public void getUserByIdFailedTest() throws Exception {
		int id = 0;
		mockMvc.perform(MockMvcRequestBuilders.get("/getUserbyId/{id}", id).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest()).andDo(print());
	}
	
	@Test
	@Ignore
	public void getAllUsers() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.get("/getAllUsers").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isAccepted()).andDo(print());
	}

}
