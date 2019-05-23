package com.exercise.web.rest;

import com.exercise.exception.NumberConvertException;
import com.exercise.service.NumberConverterService;
import com.exercise.web.response.NumberConverterResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for binary numbers.
 */
@RestController
@RequestMapping("/api/binario")
public class BinarioResource implements NumberConverterResoruce {

    private final Logger log = LoggerFactory.getLogger(BinarioResource.class);
    
    @Autowired
    private NumberConverterService service;

    @Override
    @GetMapping("/to/binario")
    public ResponseEntity<String> toBinario(String number) throws NumberConvertException {
        log.debug("REST request to get status");
        String response = service.toBinario(number);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    @GetMapping("/to/decimal")
    public ResponseEntity<String> toDecimal(String number) throws NumberConvertException {
        log.debug("REST request to get status");
        String response = service.toDecimal(number);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    @GetMapping("/to/hexa")
    public ResponseEntity<String> toHexadecimal(String number) throws NumberConvertException {
        log.debug("REST request to get status");
        String response = service.toHexa(number);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    @GetMapping("/to/romano")
    public ResponseEntity<String> toRomano(String number) throws NumberConvertException {
        log.debug("REST request to get status");
        String response = service.toRomano(number);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
