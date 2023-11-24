package com.cleanarch.domain.dto.response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import com.cleanarch.util.UserCreationUtils;

public class CreateUserResponseTest {

	@Test
	@DisplayName("Given a CreateUserResponse object with username and email, when the object is created, then the CreateUserResponse object should not be null")
	public void testCreateUserResponse_WhenObjectIsCreated_ThenObjectShouldNotBeNull() {
		// Given a CreateUserRequest object with username, password and email
		CreateUserResponse createUserResponse = UserCreationUtils.createDummyCreateUserResponse();

		// Then the CreateUserRequest object should not be null
		assertNotNull(createUserResponse);
		assertEquals("username", createUserResponse.username());
		assertEquals("email", createUserResponse.email());
	}

}
