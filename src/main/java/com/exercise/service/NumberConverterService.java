package com.exercise.service;

import com.exercise.exception.NumberConvertException;

public interface NumberConverterService {
    String toBinario(String number) throws NumberConvertException;
    String toHexa(String number) throws NumberConvertException;
    String toRomano(String number) throws NumberConvertException;
    String toDecimal(String number) throws NumberConvertException;
}
