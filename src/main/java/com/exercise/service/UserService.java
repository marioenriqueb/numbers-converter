package com.exercise.service;

import com.exercise.dto.UserDto;
import com.exercise.exception.NumberConvertException;

import java.util.List;

public interface UserService {
    UserDto findByUserName(String name);

    UserDto create(UserDto dto);

    UserDto update(UserDto dto);

    void delete(String userName);

    List<UserDto> findAll();

    UserDto login(String username);
}
