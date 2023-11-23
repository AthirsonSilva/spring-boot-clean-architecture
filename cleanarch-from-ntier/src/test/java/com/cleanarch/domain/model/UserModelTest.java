package com.cleanarch.domain.model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.cleanarch.util.UserCreationUtils;

public class UserModelTest {

	@Test
	@DisplayName("Given a UserModel object with username, password and email, when the object is created, then the UserModel object should not be null")
	public void testUserModel_WhenObjectIsCreated_ThenObjectShouldNotBeNull() {
		// Given a UserModel object with username, password and email
		UserModel userModel = UserCreationUtils.createDummyUserModel();

		// Then the UserModel object should not be null
		assertNotNull(userModel);
		assertEquals("username", userModel.username());
		assertEquals("password", userModel.password());
		assertEquals("email", userModel.email());
	}

}
