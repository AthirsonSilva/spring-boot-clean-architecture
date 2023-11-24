package com.cleanarch.infrastructure.exception;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.cleanarch.application.service.UserObjectValidation;
import com.cleanarch.domain.dto.request.CreateUserRequest;
import com.cleanarch.domain.model.UserModel;
import com.cleanarch.infrastructure.persistence.entity.UserEntity;

public class UserObjectValidationTest {

	private UserObjectValidation userObjectValidation;

	@BeforeEach
	public void setUp() {
		userObjectValidation = new UserObjectValidation();
	}

	@Test
	@DisplayName("Test validateUserEntity method when username is null")
	public void testValidateUserEntity_WhenUsernameIsNull_ReturnErrorMessage() {
		// Arrange
		UserEntity userEntity = new UserEntity();
		userEntity.setUsername(null);

		// Act
		String result = userObjectValidation.validateUserEntity(userEntity);

		// Assert
		assertThat(result).isEqualTo("Username is required");
	}

	@Test
	@DisplayName("Test validateUserEntity method when username is empty")
	public void testValidateUserEntity_WhenUsernameIsEmpty_ReturnErrorMessage() {
		// Arrange
		UserEntity userEntity = new UserEntity();
		userEntity.setUsername("");

		// Act
		String result = userObjectValidation.validateUserEntity(userEntity);

		// Assert
		assertThat(result).isEqualTo("Username is required");
	}

	// Add more test cases for validateUserEntity method

	@Test
	@DisplayName("Test validateUserModel method when username is null")
	public void testValidateUserModel_WhenUsernameIsNull_ReturnErrorMessage() {
		// Arrange
		UserModel userModel = new UserModel(null, null, null);

		// Act
		String result = userObjectValidation.validateUserModel(userModel);

		// Assert
		assertThat(result).isEqualTo("Username is required");
	}

	@Test
	@DisplayName("Test validateUserModel method when username is empty")
	public void testValidateUserModel_WhenUsernameIsEmpty_ReturnErrorMessage() {
		// Arrange
		UserModel userModel = new UserModel("", null, null);

		// Act
		String result = userObjectValidation.validateUserModel(userModel);

		// Assert
		assertThat(result).isEqualTo("Username is required");
	}

	// Add more test cases for validateUserModel method

	@Test
	@DisplayName("Test validateCreateUserRequest method when username is null")
	public void testValidateCreateUserRequest_WhenUsernameIsNull_ReturnErrorMessage() {
		// Arrange
		CreateUserRequest createUserRequest = new CreateUserRequest(null, null, null);

		// Act
		String result = userObjectValidation.validateCreateUserRequest(createUserRequest);

		// Assert
		assertThat(result).isEqualTo("Username is required");
	}

	@Test
	@DisplayName("Test validateCreateUserRequest method when username is empty")
	public void testValidateCreateUserRequest_WhenUsernameIsEmpty_ReturnErrorMessage() {
		// Arrange
		CreateUserRequest createUserRequest = new CreateUserRequest("", null, null);

		// Act
		String result = userObjectValidation.validateCreateUserRequest(createUserRequest);

		// Assert
		assertThat(result).isEqualTo("Username is required");
	}

	// Add more test cases for validateCreateUserRequest method

}