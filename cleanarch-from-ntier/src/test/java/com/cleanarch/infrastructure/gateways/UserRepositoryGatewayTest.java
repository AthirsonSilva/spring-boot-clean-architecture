package com.cleanarch.infrastructure.gateways;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cleanarch.domain.model.UserModel;

@ExtendWith(MockitoExtension.class)
public class UserRepositoryGatewayTest {

	@Mock
	private UserRepositoryGateway userRepositoryGateway;

	@Test
	@DisplayName("Given an UserModel object, when the create method is called, then an UserEntity object is returned")
	void testCreate_WhenCreateMethodIsCalled_ThenReturnUserEntityObject() {
		// given an UserModel object
		UserModel userModel = new UserModel("username", "password", "email");

		// when the create method is called
		Mockito.when(userRepositoryGateway.create(userModel)).thenReturn(userModel);
		UserModel returnedUserModel = userRepositoryGateway.create(userModel);

		// then an UserEntity object is returned
		Assertions.assertThat(returnedUserModel).isNotNull();
		Assertions.assertThat(returnedUserModel.username()).isEqualTo("username");
		Assertions.assertThat(returnedUserModel.password()).isEqualTo("password");
	}

}
