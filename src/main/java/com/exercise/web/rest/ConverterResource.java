package com.exercise.web.rest;

import com.exercise.exception.NumberConvertException;
import com.exercise.web.response.ConverterResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;

public interface ConverterResource {

    @Secured({ "ROLE_MASTER", "ROLE_BINARIO" })
    ResponseEntity<ConverterResponse> toBinario(String number) throws NumberConvertException;

    @Secured({ "ROLE_MASTER", "ROLE_DECIMAL" })
    ResponseEntity<ConverterResponse> toDecimal(String number) throws NumberConvertException;

    @Secured({ "ROLE_MASTER", "ROLE_HEXADECIMAL" })
    ResponseEntity<ConverterResponse> toHexadecimal(String number) throws NumberConvertException;

    @Secured({ "ROLE_MASTER", "ROLE_ROMANO" })
    ResponseEntity<ConverterResponse> toRomano(String number) throws NumberConvertException;
}
