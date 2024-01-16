package com.RocheIndia.Application;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.assertj.core.api.*;

import com.RocheIndia.Service.ServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TestService {

	@InjectMocks
	ServiceImpl serviceImpl;

	@Test
	public void service_generateStringspattern() {

		List<String> expectedStrings = Arrays.asList("1", "2", "fizz", "4", "buzz", "fizz", "7", "8", "fizz", "buzz",
				"11", "fizz", "13", "14", "fizzbuzz");

		List<String> strings = serviceImpl.generateStringspattern(3, 5, 15, "fizz", "buzz");

		Assertions.assertThat(strings).isEqualTo(expectedStrings);
		Assertions.assertThat(strings).contains("fizzbuzz");
		Assertions.assertThat(strings).contains("1");
		Assertions.assertThat(strings.size()).isEqualTo(15);

	}

}
