package com.cleanarch.domain.dto.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import com.cleanarch.util.UserCreationUtils;

public class CreateUserRequestTest {

	@Test
	@DisplayName("Given a CreateUserRequest object with username, password and email, when the object is created, then the CreateUserRequest object should not be null")
	public void testCreateUserRequest_WhenObjectIsCreated_ThenObjectShouldNotBeNull() {
		// Given a CreateUserRequest object with username, password and email
		CreateUserRequest createUserRequest = UserCreationUtils.createDummyCreateUserRequest();

		// Then the CreateUserRequest object should not be null
		assertNotNull(createUserRequest);
		assertEquals("username", createUserRequest.username());
		assertEquals("password", createUserRequest.password());
		assertEquals("email", createUserRequest.email());
	}

}
