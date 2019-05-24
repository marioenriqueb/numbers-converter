package com.exercise.web.rest;

import com.exercise.exception.NumberConvertException;
import com.exercise.service.ConverterService;
import com.exercise.web.response.ConverterResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for binary numbers.
 */
@RestController
@RequestMapping("/api/binario")
public class BinarioResource implements ConverterResource {

    private final Logger log = LoggerFactory.getLogger(BinarioResource.class);
    
    @Autowired
    private ConverterService service;

    @Override
    @GetMapping("/to/binario/{number}")
    public ResponseEntity<ConverterResponse> toBinario(@PathVariable("number") String number) throws NumberConvertException {
        log.debug("REST request to get status");
        ConverterResponse response = service.binarioToBinario(number);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    @GetMapping("/to/decimal/{number}")
    public ResponseEntity<ConverterResponse> toDecimal(@PathVariable("number") String number) throws NumberConvertException {
        log.debug("REST request to get status");
        ConverterResponse response = service.binarioToDecimal(number);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    @GetMapping("/to/hexa/{number}")
    public ResponseEntity<ConverterResponse> toHexadecimal(@PathVariable("number") String number) throws NumberConvertException {
        log.debug("REST request to get status");
        ConverterResponse response = service.binarioToHexa(number);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    @GetMapping("/to/romano/{number}")
    public ResponseEntity<ConverterResponse> toRomano(@PathVariable("number") String number) throws NumberConvertException {
        log.debug("REST request to get status");
        ConverterResponse response = service.binarioToRomano(number);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
