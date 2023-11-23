package com.cleanarch.interfaces.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cleanarch.application.service.UserService;
import com.cleanarch.domain.dto.request.CreateUserRequest;
import com.cleanarch.domain.dto.response.CreateUserResponse;
import com.cleanarch.interfaces.mappers.UserDtoMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	private final UserDtoMapper userDtoMapper;

	@PostMapping
	public ResponseEntity<CreateUserResponse> create(@RequestBody CreateUserRequest request) {
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(userService.create(userDtoMapper.toDomain(request)));
	}
}
