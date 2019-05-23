package com.exercise.service.impl;

import com.exercise.adapter.UserAdapter;
import com.exercise.dao.UserDao;
import com.exercise.domain.User;
import com.exercise.dto.UserDto;
import com.exercise.exception.NumberConvertException;
import com.exercise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;

	@Autowired
	private UserAdapter adapter;

	@Override
	public UserDto findById(Long userId) {
		return adapter.toDto(dao.findById(userId).orElse(null));
	}

	@Override
	public UserDto findByName(String name) {
		return adapter.toDto(dao.findByNombre(name).orElse(null));
	}

	@Override
	public UserDto create(UserDto dto) {
		User user = dao.save(adapter.toEntity(dto));
		return adapter.toDto(user);
	}

	@Override
	public UserDto update(UserDto dto) {
		if (dto.getId() != null) {
			User user = dao.findById(dto.getId()).orElse(null);
			if (user != null) {
				user.setNombre(dto.getNombre());
				dao.save(user);
				return adapter.toDto(user);
			}
		}

		return null;
	}

	@Override
	public void delete(Long userId) {
		User user = dao.findById(userId).orElse(null);
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
		User usuario = dao.findByNombre(username).orElse(null);

		if (usuario == null) {
			return null;
		}

		return this.adapter.toDto(usuario);
	}
}
