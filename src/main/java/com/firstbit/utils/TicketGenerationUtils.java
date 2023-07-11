package com.firstbit.utils;

import java.util.Random;

public class TicketGenerationUtils {

	public static String generatePNR() {
		int leftLimit = 48;
		int rightLimit = 122; //  65-90 A-Z, 97-122 a-z 
		int targetStringLength = 10;
		Random random = new Random();

		String generatedString = random.ints(leftLimit, rightLimit + 1)
				.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
		return generatedString.toUpperCase().trim();
	}
}
