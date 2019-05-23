package com.exercise.security.user;

import com.exercise.dto.UserDto;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.List;

public class UserDetailsUtils {

    public static User convertToUserDetails(UserDto dto) {
        // Remember that Spring needs roles to be in this format: "ROLE_" + userRole (i.e. "ROLE_ADMIN")
        // So, we need to set it to that format, so we can verify and compare roles (i.e. hasRole("ADMIN")).
        List authorities = new ArrayList<>();
        dto.getPermisos().stream().forEach(rol -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + rol));
        });


        // The "User" class is provided by Spring and represents a model class for user to be returned by UserDetailsService
        // And used by auth manager to verify and check user authentication.
        String password = dto.getPassword();
        return new User(dto.getNombre(), password, authorities);
    }
}
