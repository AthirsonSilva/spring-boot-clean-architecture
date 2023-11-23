package com.cleanarch.infrastructure.gateways;

import com.cleanarch.application.gateways.UserGateway;
import com.cleanarch.domain.model.UserModel;
import com.cleanarch.infrastructure.persistence.entity.UserEntity;
import com.cleanarch.infrastructure.persistence.repository.UserRepository;
import com.cleanarch.interfaces.mappers.UserEntityMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserRepositoryGateway implements UserGateway {

	private final UserRepository userRepository;
	private final UserEntityMapper userMapper;

	@Override
	public UserModel create(UserModel user) {
		UserEntity userEntity = userMapper.toEntity(user);
		UserEntity saved = userRepository.save(userEntity);

		return userMapper.toDomain(saved);
	}

}
