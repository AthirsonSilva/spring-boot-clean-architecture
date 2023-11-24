package com.cleanarch.interfaces.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cleanarch.application.service.UserService;
import com.cleanarch.domain.dto.request.CreateUserRequest;
import com.cleanarch.domain.dto.response.CreateUserResponse;
import com.cleanarch.domain.model.UserModel;
import com.cleanarch.interfaces.mappers.UserDtoMapper;
import com.cleanarch.util.UserCreationUtils;

public class UserControllerTest {

	@Mock
	private UserService userService;

	@Mock
	private UserDtoMapper userDtoMapper;

	private UserController userController;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		userController = new UserController(userService, userDtoMapper);
	}

	@Test
	@DisplayName("Given a user, when the user is created, then the created user is returned")
	public void testUserCreation_WhenUserIsCreated_ThenReturnCreatedUser() {
		// Arrange
		CreateUserRequest request = UserCreationUtils.createDummyCreateUserRequest();
		UserModel userModel = UserCreationUtils.createDummyUserModel();
		CreateUserResponse expectedResponse = UserCreationUtils.createDummyCreateUserResponse();

		Mockito.when(userDtoMapper.toDomain(request)).thenReturn(userModel);
		Mockito.when(userService.create(userModel)).thenReturn(expectedResponse);

		// Act
		ResponseEntity<CreateUserResponse> responseEntity = userController.create(request);

		// Assert
		Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		Assertions.assertThat(responseEntity.getBody()).isEqualTo(expectedResponse);

		Mockito.verify(userDtoMapper).toDomain(request);
		Mockito.verify(userService).create(userModel);
	}
}