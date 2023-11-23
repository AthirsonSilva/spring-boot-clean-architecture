package com.asilva.springbootcleanarchitecture.entrypoint.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asilva.springbootcleanarchitecture.core.domain.Customer;
import com.asilva.springbootcleanarchitecture.core.usecase.InsertCustomerUseCase;
import com.asilva.springbootcleanarchitecture.entrypoint.controller.dto.request.CustomerRequest;
import com.asilva.springbootcleanarchitecture.entrypoint.controller.mapper.CustomerMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

	private final InsertCustomerUseCase insertCustomerUseCase;
	private final CustomerMapper customerMapper;

	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest request) {
		Customer customer = customerMapper.toDomain(request);
		insertCustomerUseCase.insert(customer, request.getZipCode());

		return ResponseEntity.ok().build();
	}

}
