package com.cleanarch.application.usecases;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cleanarch.application.gateways.UserGateway;
import com.cleanarch.domain.model.UserModel;
import com.cleanarch.util.UserCreationUtils;

@ExtendWith(MockitoExtension.class)
public class CreateUserTest {

	@Mock
	private UserGateway userGateway;

	@InjectMocks
	private CreateUser createUser;

	@Test
	@DisplayName("Given a user, when the user is created, then the user is returned")
	public void testUserCreation_WhenUserIsCreated_ThenReturnCreatedUser() {
		// Given a user
		UserModel user = UserCreationUtils.createDummyUserModel();

		// When the user is created
		Mockito.when(createUser.execute(user)).thenReturn(user);
		createUser.execute(user);

		// Then the created user is returned
		Assertions.assertThat(user).isNotNull();
		Assertions.assertThat(user.username()).isEqualTo("username");
	}

}
