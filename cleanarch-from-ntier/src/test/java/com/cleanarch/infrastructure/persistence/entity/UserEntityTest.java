package com.cleanarch.infrastructure.persistence.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.cleanarch.util.UserCreationUtils;

public class UserEntityTest {

	@Test
	@DisplayName("Given a UserEntity object with username, password and email, when the object is created, then the UserEntity object should not be null")
	void testUserEntity_WhenObjectIsCreated_ThenObjectShouldNotBeNull() {
		// given a UserEntity object with username, password and email
		// when the object is created
		UserEntity userEntity = UserCreationUtils.createDummyUserEntity();

		// then
		Assertions.assertThat(userEntity).isNotNull();
		Assertions.assertThat(userEntity.getUsername()).isEqualTo("username");
		Assertions.assertThat(userEntity.getPassword()).isEqualTo("password");
		Assertions.assertThat(userEntity.getEmail()).isEqualTo("email");
	}

}
