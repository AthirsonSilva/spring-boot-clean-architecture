package com.cleanarch.interfaces.mappers;

import com.cleanarch.domain.dto.request.CreateUserRequest;
import com.cleanarch.domain.dto.response.CreateUserResponse;
import com.cleanarch.domain.model.UserModel;

public class UserDtoMapper {

	public CreateUserResponse toResponse(UserModel domainObject) {
		CreateUserResponse createUserResponse = new CreateUserResponse(
				domainObject.username(), domainObject.email());

		return createUserResponse;
	}

	public UserModel toDomain(CreateUserRequest response) {
		UserModel userModel = new UserModel(response.username(), response.password(), response.email());

		return userModel;
	}

}
