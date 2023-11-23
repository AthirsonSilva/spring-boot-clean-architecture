package com.cleanarch.application.gateways;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cleanarch.domain.model.UserModel;
import com.cleanarch.util.UserCreationUtils;

@ExtendWith(MockitoExtension.class)
public class UserGatewayTest {

	@Mock
	private UserGateway userGateway;

	@Test
	@DisplayName("Given a user, when the user is created, then the created user is returned")
	public void testUserCreation_WhenUserIsCreated_ThenReturnCreatedUser() {
		// Given a user
		UserModel user = UserCreationUtils.createDummyUserModel();

		// When the user is created
		Mockito.when(userGateway.create(user)).thenReturn(user);
		UserModel returnedUser = userGateway.create(user);

		// Then the created user is returned
		Assertions.assertThat(returnedUser).isNotNull();
		Assertions.assertThat(returnedUser.username()).isEqualTo("username");
	}

}
