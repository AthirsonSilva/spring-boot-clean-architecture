package com.cleanarch.application.service;

import com.cleanarch.application.usecases.CreateUser;
import com.cleanarch.domain.dto.response.CreateUserResponse;
import com.cleanarch.domain.model.UserModel;
import com.cleanarch.infrastructure.exception.UserValidationException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserService {

	private final CreateUser createUser;
	private final UserObjectValidation userValidationService;

	public CreateUserResponse create(UserModel user) {
		String validationMessage = userValidationService.validateUserModel(user);

		if (validationMessage != null)
			throw new UserValidationException(validationMessage);

		UserModel modelObj = createUser.execute(user);

		return new CreateUserResponse(modelObj.username(), modelObj.email());
	}
}
