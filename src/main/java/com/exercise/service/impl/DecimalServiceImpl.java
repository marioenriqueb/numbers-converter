package com.exercise.service.impl;

import com.exercise.exception.NumberConvertException;
import com.exercise.service.NumberConverterService;
import com.exercise.service.utils.RomanNumber;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
public class DecimalServiceImpl implements NumberConverterService {

	@Override
	public String toBinario(String number) throws NumberConvertException {
		try {
			return String.format("%s", Integer.toBinaryString(new Integer(number)));
		} catch (Exception ex) {
			throw new NumberConvertException("cant convert");
		}
	}

	@Override
	public String toHexa(String number) throws NumberConvertException {
		try {
			return String.format("%x", new Integer(number));
		} catch (Exception ex) {
			throw new NumberConvertException("cant convert");
		}
	}

	@Override
	public String toRomano(String number) throws NumberConvertException {
		try {
			Integer integer = new Integer(number);
			return String.format("%s", RomanNumber.toRoman(integer));
		} catch (Exception ex) {
			throw new NumberConvertException("cant convert");
		}
	}

	@Override
	public String toDecimal(String number) throws NumberConvertException {
		try {
			return String.format("%d", new Integer(number));
		} catch (Exception ex) {
			throw new NumberConvertException("cant convert");
		}
	}
}
