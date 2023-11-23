package com.cleanarch.interfaces.mappers;

import com.cleanarch.domain.model.UserModel;
import com.cleanarch.infrastructure.persistence.entity.UserEntity;

public class UserEntityMapper {

	public UserEntity toEntity(UserModel domainObject) {
		UserEntity userEntity = new UserEntity();

		userEntity.setUsername(domainObject.username());
		userEntity.setPassword(domainObject.password());
		userEntity.setEmail(domainObject.email());

		return userEntity;
	}

	public UserModel toDomain(UserEntity entityObject) {
		UserModel userModel = new UserModel(
				entityObject.getUsername(), entityObject.getPassword(),
				entityObject.getEmail());

		return userModel;
	}

}
