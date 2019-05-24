package com.exercise.service.impl;

import com.exercise.service.ConverterService;
import com.exercise.service.utils.DecimalNumberUtils;
import com.exercise.service.utils.RomanNumberUtils;
import org.springframework.stereotype.Component;

import com.exercise.exception.NumberConvertException;

@Component
public class ConverterServiceImpl implements ConverterService {

	@Override
	public String hexaToBinario(String number) throws NumberConvertException {
		Long value = DecimalNumberUtils.hexaToDecimal(number);
		return toBinario(value);
	}

	@Override
	public String hexaToHexa(String number) throws NumberConvertException {
		Long value = DecimalNumberUtils.hexaToDecimal(number);
		return toHexa(value);
	}

	@Override
	public String hexaToRomano(String number) throws NumberConvertException {
		Long value = DecimalNumberUtils.hexaToDecimal(number);
		return toRomano(value);
	}

	@Override
	public String hexaToDecimal(String number) throws NumberConvertException {
		Long value = DecimalNumberUtils.hexaToDecimal(number);
		return toDecimal(value);
	}

	@Override
	public String binarioToBinario(String number) throws NumberConvertException {
		Long value = DecimalNumberUtils.binaryToDecimal(number);
		return toBinario(value);
	}

	@Override
	public String binarioToHexa(String number) throws NumberConvertException {
		Long value = DecimalNumberUtils.binaryToDecimal(number);
		return toHexa(value);
	}

	@Override
	public String binarioToRomano(String number) throws NumberConvertException {
		Long value = DecimalNumberUtils.binaryToDecimal(number);
		return toRomano(value);
	}

	@Override
	public String binarioToDecimal(String number) throws NumberConvertException {
		Long value = DecimalNumberUtils.binaryToDecimal(number);
		return toDecimal(value);
	}

	@Override
	public String decimalToBinario(String number) throws NumberConvertException {
		Long value = DecimalNumberUtils.stringToDecimal(number);
		return toBinario(value);
	}

	@Override
	public String decimalToHexa(String number) throws NumberConvertException {
		Long value = DecimalNumberUtils.stringToDecimal(number);
		return toHexa(value);
	}

	@Override
	public String decimalToRomano(String number) throws NumberConvertException {
		Long value = DecimalNumberUtils.stringToDecimal(number);
		return toRomano(value);
	}

	@Override
	public String decimalToDecimal(String number) throws NumberConvertException {
		Long value = DecimalNumberUtils.stringToDecimal(number);
		return toDecimal(value);
	}

	private String toBinario(Long value) throws NumberConvertException {
		if (value != null) {
			return Long.toBinaryString(value);
		}

		throw new NumberConvertException("cant convert");
	}

	private String toHexa(Long value) throws NumberConvertException {
		if (value != null) {
			return Long.toHexString(value).toUpperCase();
		}

		throw new NumberConvertException("cant convert");
	}

	private String toRomano(Long value) throws NumberConvertException {
		if (value != null) {
			return RomanNumberUtils.toRoman(value);
		}

		throw new NumberConvertException("cant convert");
	}

	private String toDecimal(Long value) throws NumberConvertException {
		if (value != null) {
			return String.valueOf(value);
		}

		throw new NumberConvertException("cant convert");
	}
}
