package com.exercise.web.rest;

import com.exercise.exception.NumberConvertException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;

public interface ConverterResource {

    @Secured({ "ROLE_MASTER", "ROLE_BINARIO" })
    ResponseEntity<String> toBinario(String number) throws NumberConvertException;

    @Secured({ "ROLE_MASTER", "ROLE_DECIMAL" })
    ResponseEntity<String> toDecimal(String number) throws NumberConvertException;

    @Secured({ "ROLE_MASTER", "ROLE_HEXADECIMAL" })
    ResponseEntity<String> toHexadecimal(String number) throws NumberConvertException;

    @Secured({ "ROLE_MASTER", "ROLE_ROMANO" })
    ResponseEntity<String> toRomano(String number) throws NumberConvertException;
}
