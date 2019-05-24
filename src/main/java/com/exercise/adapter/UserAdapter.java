package com.exercise.adapter;

import com.exercise.domain.User;
import com.exercise.domain.UserPermission;
import com.exercise.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserAdapter extends Adapter<User, UserDto> {

    @Override
    public User toEntity(UserDto dto) {
        if (dto == null) {
            return null;
        }

        User entity = new User();
        entity.setUserName(dto.getNombre());
        entity.setPassword(dto.getPassword());

        dto.getPermisos().forEach(perm -> {
            UserPermission permission = new UserPermission();
            permission.setPermission(perm);
            permission.setUserName(dto.getNombre());
            entity.getPermisos().add(permission);
        });

        return entity;
    }

    @Override
    public UserDto toDto(User entity) {
        if (entity == null) {
            return null;
        }

        UserDto dto = new UserDto();
        dto.setNombre(entity.getUserName());

        entity.getPermisos().forEach(perm -> dto.getPermisos().add(perm.getPermission()));

        return dto;
    }
}
