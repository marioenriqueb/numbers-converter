package com.exercise.service;

import com.exercise.exception.NumberConvertException;
import com.exercise.web.response.ConverterResponse;

public interface ConverterService {
    ConverterResponse hexaToBinario(String number) throws NumberConvertException;
    ConverterResponse hexaToHexa(String number) throws NumberConvertException;
    ConverterResponse hexaToRomano(String number) throws NumberConvertException;
    ConverterResponse hexaToDecimal(String number) throws NumberConvertException;

    ConverterResponse binarioToBinario(String number) throws NumberConvertException;
    ConverterResponse binarioToHexa(String number) throws NumberConvertException;
    ConverterResponse binarioToRomano(String number) throws NumberConvertException;
    ConverterResponse binarioToDecimal(String number) throws NumberConvertException;

    ConverterResponse decimalToBinario(String number) throws NumberConvertException;
    ConverterResponse decimalToHexa(String number) throws NumberConvertException;
    ConverterResponse decimalToRomano(String number) throws NumberConvertException;
    ConverterResponse decimalToDecimal(String number) throws NumberConvertException;
}
