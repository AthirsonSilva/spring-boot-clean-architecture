package com.cleanarch.interfaces.mappers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.cleanarch.domain.model.UserModel;
import com.cleanarch.infrastructure.persistence.entity.UserEntity;
import com.cleanarch.util.UserCreationUtils;

public class UserEntityMapperTest {

	private UserEntityMapper userEntityMapper = new UserEntityMapper();

	@Test
	@DisplayName("Given a UserEntity object, when the object is mapped to UserModel, then the UserModel object should be returned")
	void testMapUserModelToUserEntity_WhenObjectIsMappedToUserEntity_ThenUserEntityObjectShouldBeReturned() {
		// given a UserModel object with username, password and email
		UserModel userModel = new UserModel("username", "password", "email");

		// when the object is mapped to UserEntity
		UserEntity userEntity = userEntityMapper.toEntity(userModel);

		// then
		Assertions.assertThat(userEntity).isNotNull();
		Assertions.assertThat(userEntity.getUsername()).isEqualTo(userModel.username());
		Assertions.assertThat(userEntity.getPassword()).isEqualTo(userModel.password());
		Assertions.assertThat(userEntity.getEmail()).isEqualTo(userModel.email());
	}

	@Test
	@DisplayName("Given a UserModel object, when the object is mapped to UserEntity, then the UserEntity object should be returned")
	void testMapUserEntityToUserModel_WhenObjectIsMappedToUserModel_ThenUserModelObjectShouldBeReturned() {
		// given a UserModel object with username, password and email
		UserEntity userEntity = UserCreationUtils.createDummyUserEntity();

		// when the object is mapped to UserEntity
		UserModel userModel = userEntityMapper.toDomain(userEntity);

		// then
		Assertions.assertThat(userModel).isNotNull();
		Assertions.assertThat(userModel.username()).isEqualTo(userEntity.getUsername());
		Assertions.assertThat(userModel.password()).isEqualTo(userEntity.getPassword());
		Assertions.assertThat(userModel.email()).isEqualTo(userEntity.getEmail());
	}

	@Test
	@DisplayName("Given a null UserEntity object, when the object is mapped to UserModel, then the UserModel object should be returned")
	void testMapUserModelToUserEntity_WhenObjectIsNull_ThenUserEntityObjectShouldBeReturned() {
		// given
		UserModel userModel = new UserModel(null, null, null);

		// when
		UserEntity userEntity = userEntityMapper.toEntity(userModel);

		// then
		Assertions.assertThat(userEntity).isNotNull();
		Assertions.assertThat(userEntity.getUsername()).isNull();
	}

	@Test
	@DisplayName("Given a null UserModel object, when the object is mapped to UserEntity, then the UserEntity object should be returned")
	void testMapUserEntityToUserModel_WhenObjectIsNull_ThenUserModelObjectShouldBeReturned() {
		// given
		UserEntity userEntity = new UserEntity();

		// when
		UserModel userModel = userEntityMapper.toDomain(userEntity);

		// then
		Assertions.assertThat(userModel).isNotNull();
		Assertions.assertThat(userModel.username()).isNull();
	}

}