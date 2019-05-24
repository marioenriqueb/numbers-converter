package com.exercise.web.rest;

import com.exercise.exception.NumberConvertException;
import com.exercise.service.UserService;
import com.exercise.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing Rovert.
 */
@RestController
@RequestMapping("/api/user")
public class UserResource {

    private final Logger log = LoggerFactory.getLogger(UserResource.class);
    
    @Autowired
    private UserService service;

    @GetMapping("/find/{username}")
    public ResponseEntity<UserDto> findByName(String username) throws NumberConvertException {
        log.debug("REST request to find an user : {}", username);
        UserDto usuario = service.findByUserName(username);
        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> findAll() throws NumberConvertException {
        log.debug("REST request to find all users");
        List<UserDto> usuario = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody UserDto dto) throws NumberConvertException {
        log.debug("REST request to create an user : {}", dto);
        UserDto usuario = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @PutMapping
    public ResponseEntity<UserDto> update(@RequestBody UserDto dto) throws NumberConvertException {
        log.debug("REST request to update an user : {}", dto);
        if (dto.getNombre() != null) {
            UserDto usuario = service.update(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<UserDto> delete(String username) throws NumberConvertException {
        log.debug("REST request to delete an user : {}", username);
        if (username != null) {
            service.delete(username);
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
