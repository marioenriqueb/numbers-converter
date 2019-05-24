package com.exercise.web.rest;

import com.exercise.exception.NumberConvertException;
import org.springframework.http.ResponseEntity;

public interface ConverterResource {
    ResponseEntity<String> toBinario(String number) throws NumberConvertException;
    ResponseEntity<String> toDecimal(String number) throws NumberConvertException;
    ResponseEntity<String> toHexadecimal(String number) throws NumberConvertException;
    ResponseEntity<String> toRomano(String number) throws NumberConvertException;
}
