package com.cleanarch.application.service;

import com.cleanarch.domain.dto.request.CreateUserRequest;
import com.cleanarch.domain.model.UserModel;
import com.cleanarch.infrastructure.persistence.entity.UserEntity;

public class UserObjectValidation {

	public String validateUserEntity(UserEntity userEntity) {
		if (userEntity.getUsername() == null || userEntity.getUsername().isEmpty())
			return "Username is required";

		else if (userEntity.getPassword() == null || userEntity.getPassword().isEmpty())
			return "Password is required";

		else if (userEntity.getEmail() == null || userEntity.getEmail().isEmpty())
			return "Email is required";

		return null;
	}

	public String validateUserModel(UserModel userModel) {
		if (userModel.username() == null || userModel.username().isEmpty())
			return "Username is required";

		else if (userModel.password() == null || userModel.password().isEmpty())
			return "Password is required";

		else if (userModel.email() == null || userModel.email().isEmpty())
			return "Email is required";

		return null;
	}

	public String validateCreateUserRequest(CreateUserRequest createUserRequest) {
		if (createUserRequest.username() == null || createUserRequest.username().isEmpty())
			return "Username is required";

		else if (createUserRequest.password() == null || createUserRequest.password().isEmpty())
			return "Password is required";

		else if (createUserRequest.email() == null || createUserRequest.email().isEmpty())
			return "Email is required";

		return null;
	}

}
