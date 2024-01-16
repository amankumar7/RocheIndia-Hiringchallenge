package com.RocheIndia.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.RocheIndia.Service.ServiceImpl;

@RestController
@RequestMapping("/api/v1")
public class HiringChallengeController {

	@Autowired
	private ServiceImpl serviceImpl;

	@GetMapping("/strings")
	public ResponseEntity<List<String>> generateStringspattern(@RequestParam(name = "int1", required = true) int int1,
			@RequestParam(name = "int2", required = true) int int2,
			@RequestParam(name = "limit", required = true) int limit,
			@RequestParam(name = "str1", required = true) String str1, @RequestParam("str2") String str2) {

		List<String> result = serviceImpl.generateStringspattern(int1, int2, limit, str1, str2);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/statistics")
	public ResponseEntity<String> getStatistics() {
		return ResponseEntity.ok(serviceImpl.getStatistics());
	}

}
