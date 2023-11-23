package com.cleanarch.util;

import com.cleanarch.domain.dto.request.CreateUserRequest;
import com.cleanarch.domain.dto.response.CreateUserResponse;
import com.cleanarch.domain.model.UserModel;
import com.cleanarch.infrastructure.persistence.entity.UserEntity;

public class UserCreationUtils {

	public static UserModel createDummyUserModel() {
		return new UserModel("username", "password", "email");
	}

	public static UserModel createDummyUserModel(String username, String password, String email) {
		return new UserModel(username, password, email);
	}

	public static CreateUserResponse createDummyCreateUserResponse() {
		return new CreateUserResponse("username", "email");
	}

	public static CreateUserResponse createDummyCreateUserResponse(String username, String email) {
		return new CreateUserResponse(username, email);
	}

	public static CreateUserRequest createDummyCreateUserRequest() {
		return new CreateUserRequest("username", "email", "password");
	}

	public static CreateUserRequest createDummyCreateUserRequest(String username, String password, String email) {
		return new CreateUserRequest(username, password, email);
	}

	public static UserEntity createDummyUserEntity() {
		UserEntity userEntity = new UserEntity();
		userEntity.setUsername("username");
		userEntity.setPassword("password");
		userEntity.setEmail("email");

		return userEntity;
	}

	public static UserEntity createDummyUserEntity(String username, String password, String email) {
		UserEntity userEntity = new UserEntity();
		userEntity.setUsername(username);
		userEntity.setPassword(password);
		userEntity.setEmail(email);

		return userEntity;
	}

}
