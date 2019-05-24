package com.exercise.service;

import com.exercise.exception.NumberConvertException;

public interface ConverterService {
    String hexaToBinario(String number) throws NumberConvertException;
    String hexaToHexa(String number) throws NumberConvertException;
    String hexaToRomano(String number) throws NumberConvertException;
    String hexaToDecimal(String number) throws NumberConvertException;

    String binarioToBinario(String number) throws NumberConvertException;
    String binarioToHexa(String number) throws NumberConvertException;
    String binarioToRomano(String number) throws NumberConvertException;
    String binarioToDecimal(String number) throws NumberConvertException;

    String decimalToBinario(String number) throws NumberConvertException;
    String decimalToHexa(String number) throws NumberConvertException;
    String decimalToRomano(String number) throws NumberConvertException;
    String decimalToDecimal(String number) throws NumberConvertException;
}
