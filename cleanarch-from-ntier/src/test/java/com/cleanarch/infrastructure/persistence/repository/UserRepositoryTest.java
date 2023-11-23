package com.cleanarch.infrastructure.persistence.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cleanarch.infrastructure.persistence.entity.UserEntity;
import com.cleanarch.util.UserCreationUtils;

@ExtendWith(MockitoExtension.class)
public class UserRepositoryTest {

	@Mock
	private UserRepository userRepository;

	@Test
	@DisplayName("Given a UserEntity object, when the save method is called, then a UserEntity object is returned")
	void testSave_WhenSaveMethodIsCalled_ThenReturnUserEntityObject() {
		// given a UserEntity object
		UserEntity userEntity = UserCreationUtils.createDummyUserEntity();

		// when the save method is called
		Mockito.when(userRepository.save(userEntity)).thenReturn(userEntity);

		// then
		Assertions.assertThat(userRepository.save(userEntity)).isNotNull();
		Assertions.assertThat(userRepository.save(userEntity).getUsername()).isEqualTo("username");
		Assertions.assertThat(userRepository.save(userEntity).getPassword()).isEqualTo("password");
		Assertions.assertThat(userRepository.save(userEntity).getEmail()).isEqualTo("email");
	}

}
