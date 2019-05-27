package com.fce.fceintegrationservice;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fce.pojo.QuoteRequest;
import com.fce.util.AppConstants;

@SpringBootTest(properties = { "eureka.client.enabled=false", "ribbon.eureka.enable=false",
		"passenger-management.ribbon.listOfServers=passenger-management",
		"driver-management.ribbon.listOfServers=driver-management" })
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
public class FceIntegrationServiceApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void createEmployeeAPI() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post(AppConstants.URL_ROOT + AppConstants.URL_GET)
				.content(asJsonString(new QuoteRequest("My Car"))).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.jsonPath("$.employeeId").exists());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
