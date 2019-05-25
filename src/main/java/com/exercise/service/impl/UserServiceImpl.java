package com.exercise.service.impl;

import com.exercise.adapter.UserAdapter;
import com.exercise.dao.UserDao;
import com.exercise.domain.User;
import com.exercise.domain.UserPermission;
import com.exercise.dto.UserDto;
import com.exercise.exception.NumberConvertException;
import com.exercise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;

	@Autowired
	private UserAdapter adapter;

	@Override
	public UserDto findByUserName(String userName) {
		return adapter.toDto(dao.findById(userName).orElse(null));
	}

	@Override
	public UserDto create(UserDto dto) {
		User user = dao.save(adapter.toEntity(dto));
		return adapter.toDto(user);
	}

	@Override
	public UserDto update(UserDto dto) {
		if (dto.getNombre() != null) {
			User user = dao.findById(dto.getNombre()).orElse(null);
			if (user != null) {
				List<UserPermission> permissions = dto.getPermisos().stream()
						.map(permission -> new UserPermission(user.getUserName(), permission))
						.collect(Collectors.toList());
				user.setPermisos(permissions);

				dao.save(user);
				return adapter.toDto(user);
			}
		}

		return null;
	}

	@Override
	public void delete(String userName) {
		User user = dao.findById(userName).orElse(null);
		if (user != null) {
			this.dao.delete(user);
		}
	}

	@Override
	public List<UserDto> findAll() {
		return adapter.toDtoList(this.dao.findAll());
	}

	@Override
	public UserDto login(String username) {
		User usuario = dao.findById(username).orElse(null);

		if (usuario == null) {
			return null;
		}

		UserDto loginDto = this.adapter.toDto(usuario);
		loginDto.setPassword(usuario.getPassword());
		return loginDto;
	}
}
