package com.excercise.utils;

import com.exercise.domain.enumeration.Permission;
import com.exercise.dto.UserDto;

/**
 * Created by mario on 25/05/2019.
 */
public class TestUtils {

    public static String USER_NAME = "test";
    public static String PASSWORD = "password";

    public static UserDto createUserDto() {
        // Before
        UserDto dto = new UserDto();
        dto.setNombre(USER_NAME);
        dto.setPassword(PASSWORD);
        dto.getPermisos().add(Permission.BINARIO);
        dto.getPermisos().add(Permission.HEXADECIMAL);
        return dto;
    }
}
