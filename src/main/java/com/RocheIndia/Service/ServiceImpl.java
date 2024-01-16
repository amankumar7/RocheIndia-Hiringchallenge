package com.RocheIndia.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements IService {

	private static String mostUsedRequest = "";
	private static String parameters = "";
	private static int noOfHits = 0;

	@Override
	public List<String> generateStringspattern(int int1, int int2, int limit, String str1, String str2) {

		List<String> result = new ArrayList<String>();

		for (int num = 1; num <= limit; num++) {
			if (num % int1 == 0 && num % int2 == 0) {
				result.add(str1 + str2);
			} else if (num % int1 == 0) {
				result.add(str1);
			} else if (num % int2 == 0) {
				result.add(str2);
			} else {
				result.add(Integer.toString(num));
			}
		}
		String request = String.format("/strings?int1=%d&int2=%d&limit=%d&str1=%s&str2=%s", int1, int2, limit, str1,
				str2);
		updateStats(request, int1, int2, limit, str1, str2);

		return result;

	}

	@Override
	public String getStatistics() {
		if (mostUsedRequest == null) {
			return "No statistics available.";
		} else {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("Most frequent Request : ");
			stringBuilder.append(mostUsedRequest);
			stringBuilder.append(" .With parameter -> ");
			stringBuilder.append(parameters);
			stringBuilder.append(" .The number of hits for the most frequent request : ");
			stringBuilder.append(noOfHits);

			return stringBuilder.toString();
		}
	}

	public void updateStats(String requestString, int int1, int int2, int limit, String str1, String str2) {

		if (mostUsedRequest == null || mostUsedRequest.equals(requestString)) {
			mostUsedRequest = requestString;
			noOfHits++;
		} else {
			mostUsedRequest = requestString;
			noOfHits = 1;
		}
		parameters = String.format("int1 : %d, int2 : %d, limit : %d, str1 : %s , str2 : %s", int1, int2, limit, str1,
				str2);
	}

}
