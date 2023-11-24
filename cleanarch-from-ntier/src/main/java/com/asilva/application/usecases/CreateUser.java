package com.cleanarch.application.usecases;

import com.cleanarch.application.gateways.UserGateway;
import com.cleanarch.domain.model.UserModel;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateUser {

	private final UserGateway userGateway;

	public UserModel execute(UserModel user) {
		return userGateway.create(user);
	}

}
