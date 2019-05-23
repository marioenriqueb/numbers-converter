package com.exercise.service;

import com.exercise.dto.UserDto;
import com.exercise.exception.NumberConvertException;

import java.util.List;

public interface UserService {
    UserDto findById(Long userId);

    UserDto findByName(String name);

    UserDto create(UserDto dto);

    UserDto update(UserDto dto);

    void delete(Long userId);

    List<UserDto> findAll();

    UserDto login(String username);
}
