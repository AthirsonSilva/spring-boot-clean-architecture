package com.cleanarch.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cleanarch.application.gateways.UserGateway;
import com.cleanarch.application.service.UserObjectValidation;
import com.cleanarch.application.service.UserService;
import com.cleanarch.application.usecases.CreateUser;
import com.cleanarch.infrastructure.gateways.UserRepositoryGateway;
import com.cleanarch.infrastructure.persistence.repository.UserRepository;
import com.cleanarch.interfaces.mappers.UserDtoMapper;
import com.cleanarch.interfaces.mappers.UserEntityMapper;

@Configuration
public class UserDependecyInjection {

	@Bean
	CreateUser createUser(UserGateway userGateway) {
		return new CreateUser(userGateway);
	}

	@Bean
	UserGateway userGateway(UserRepository userRepository, UserEntityMapper userMapper) {
		return new UserRepositoryGateway(userRepository, userMapper);
	}

	@Bean
	UserEntityMapper userEntityMapper() {
		return new UserEntityMapper();
	}

	@Bean
	UserDtoMapper userDtoMapper() {
		return new UserDtoMapper();
	}

	@Bean
	UserObjectValidation userValidationService() {
		return new UserObjectValidation();
	}

	@Bean
	UserService userService(CreateUser createUser, UserObjectValidation userValidationService) {
		return new UserService(createUser, userValidationService);
	}

}
