package com.exercise.web.rest;

import com.exercise.exception.NumberConvertException;
import com.exercise.service.ConverterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for binary numbers.
 */
@RestController
@RequestMapping("/api/decimal")
public class DecimalResource implements ConverterResource {

    private final Logger log = LoggerFactory.getLogger(DecimalResource.class);
    
    @Autowired
    private ConverterService service;

    @Override
    @GetMapping("/to/binario")
    public ResponseEntity<String> toBinario(String number) throws NumberConvertException {
        log.debug("REST request to get status");
        String response = service.decimalToBinario(number);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    @GetMapping("/to/decimal")
    public ResponseEntity<String> toDecimal(String number) throws NumberConvertException {
        log.debug("REST request to get status");
        String response = service.decimalToDecimal(number);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    @GetMapping("/to/hexa")
    public ResponseEntity<String> toHexadecimal(String number) throws NumberConvertException {
        log.debug("REST request to get status");
        String response = service.decimalToHexa(number);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    @GetMapping("/to/romano")
    public ResponseEntity<String> toRomano(String number) throws NumberConvertException {
        log.debug("REST request to get status");
        String response = service.decimalToRomano(number);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
