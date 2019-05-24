package com.exercise.service.impl;

import com.exercise.domain.enumeration.Permission;
import com.exercise.service.ConverterService;
import com.exercise.service.utils.DecimalNumberUtils;
import com.exercise.service.utils.RomanNumberUtils;
import com.exercise.web.response.ConverterResponse;
import org.springframework.stereotype.Component;

import com.exercise.exception.NumberConvertException;

@Component
public class ConverterServiceImpl implements ConverterService {

	@Override
	public ConverterResponse hexaToBinario(String number) throws NumberConvertException {
		Long value = DecimalNumberUtils.hexaToDecimal(number);
		String result = toBinario(value);
		return new ConverterResponse(number, result, Permission.BINARIO);
	}

	@Override
	public ConverterResponse hexaToHexa(String number) throws NumberConvertException {
		Long value = DecimalNumberUtils.hexaToDecimal(number);
		String result = toHexa(value);
		return new ConverterResponse(number, result, Permission.HEXADECIMAL);
	}

	@Override
	public ConverterResponse hexaToRomano(String number) throws NumberConvertException {
		Long value = DecimalNumberUtils.hexaToDecimal(number);
		String result = toRomano(value);
		return new ConverterResponse(number, result, Permission.ROMANO);
	}

	@Override
	public ConverterResponse hexaToDecimal(String number) throws NumberConvertException {
		Long value = DecimalNumberUtils.hexaToDecimal(number);
		String result = toDecimal(value);
		return new ConverterResponse(number, result, Permission.DECIMAL);
	}

	@Override
	public ConverterResponse binarioToBinario(String number) throws NumberConvertException {
		Long value = DecimalNumberUtils.binaryToDecimal(number);
		String result = toBinario(value);
		return new ConverterResponse(number, result, Permission.BINARIO);
	}

	@Override
	public ConverterResponse binarioToHexa(String number) throws NumberConvertException {
		Long value = DecimalNumberUtils.binaryToDecimal(number);
		String result = toHexa(value);
		return new ConverterResponse(number, result, Permission.HEXADECIMAL);
	}

	@Override
	public ConverterResponse binarioToRomano(String number) throws NumberConvertException {
		Long value = DecimalNumberUtils.binaryToDecimal(number);
		String result = toRomano(value);
		return new ConverterResponse(number, result, Permission.ROMANO);
	}

	@Override
	public ConverterResponse binarioToDecimal(String number) throws NumberConvertException {
		Long value = DecimalNumberUtils.binaryToDecimal(number);
		String result = toDecimal(value);
		return new ConverterResponse(number, result, Permission.DECIMAL);
	}

	@Override
	public ConverterResponse decimalToBinario(String number) throws NumberConvertException {
		Long value = DecimalNumberUtils.stringToDecimal(number);
		String result = toBinario(value);
		return new ConverterResponse(number, result, Permission.BINARIO);
	}

	@Override
	public ConverterResponse decimalToHexa(String number) throws NumberConvertException {
		Long value = DecimalNumberUtils.stringToDecimal(number);
		String result = toHexa(value);
		return new ConverterResponse(number, result, Permission.HEXADECIMAL);
	}

	@Override
	public ConverterResponse decimalToRomano(String number) throws NumberConvertException {
		Long value = DecimalNumberUtils.stringToDecimal(number);
		String result = toRomano(value);
		return new ConverterResponse(number, result, Permission.ROMANO);
	}

	@Override
	public ConverterResponse decimalToDecimal(String number) throws NumberConvertException {
		Long value = DecimalNumberUtils.stringToDecimal(number);
		String result = toDecimal(value);
		return new ConverterResponse(number, result, Permission.DECIMAL);
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
