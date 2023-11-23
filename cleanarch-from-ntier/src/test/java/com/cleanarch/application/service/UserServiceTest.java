package com.cleanarch.application.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cleanarch.domain.dto.response.CreateUserResponse;
import com.cleanarch.domain.model.UserModel;
import com.cleanarch.util.UserCreationUtils;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@Mock
	private UserService userService;

	@Test
	@DisplayName("Given a user, when the user is created, then the created user is returned")
	public void testUserCreation_WhenUserIsCreated_ThenReturnCreatedUser() {
		// Given a user
		UserModel user = UserCreationUtils.createDummyUserModel();

		// When the user is created
		Mockito
				.when(userService.create(user))
				.thenReturn(new CreateUserResponse(user.username(), user.email()));
		CreateUserResponse returnedUser = userService.create(user);

		// Then the created user is returned
		Assertions.assertThat(returnedUser).isNotNull();
		Assertions.assertThat(returnedUser.username()).isEqualTo("username");
		Assertions.assertThat(returnedUser.email()).isEqualTo("email");
	}

}
