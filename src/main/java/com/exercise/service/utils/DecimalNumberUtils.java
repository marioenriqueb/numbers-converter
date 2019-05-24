package com.exercise.service.utils;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class DecimalNumberUtils {
	private static final Pattern BINARY_PETTERN = Pattern.compile("[01]+");
	private static final Pattern HEXA_PETTERN = Pattern.compile("[0-9A-F]+");
	private static final Pattern DECIMAL_PETTERN = Pattern.compile("[0-9]+");

	public static Long hexaToDecimal(String value) {
		Long number = null;

		if (HEXA_PETTERN.matcher(value).matches()) {
			number = Long.parseLong(value, 16);
		}

		return number;
	}

	public static Long binaryToDecimal(String value) {
		Long number = null;

		if (BINARY_PETTERN.matcher(value).matches()) {
			number = Long.parseLong(value, 2);
		}

		return number;
	}

	public static Long stringToDecimal(String value) {
		Long number = null;

		if (DECIMAL_PETTERN.matcher(value).matches()) {
			number = Long.parseLong(value, 10);;
		}

		return number;
	}
}
