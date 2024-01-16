package com.RocheIndia.Application;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.RocheIndia.Controller.HiringChallengeController;
import com.RocheIndia.Service.ServiceImpl;

@WebMvcTest(HiringChallengeController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class TestController {

	@Mock
	private ServiceImpl serviceImpl;

	@Autowired
	private MockMvc mockMvc;

	@InjectMocks
	private HiringChallengeController hiringChallengeController;

	@Test
	public void getStringsTest() throws Exception {

		mockMvc.perform(
				MockMvcRequestBuilders.get("/api/v1/strings").param("int1", "3").param("int2", "5").param("limit", "15")
						.param("str1", "fizz").param("str2", "buzz").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
				.andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(15))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0]").value(1))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1]").value(2))
				.andExpect(MockMvcResultMatchers.jsonPath("$[14]").value("fizzbuzz"));
	}

}
