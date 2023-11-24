package com.asilva.springbootcleanarchitecture.entrypoint.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asilva.springbootcleanarchitecture.core.domain.Customer;
import com.asilva.springbootcleanarchitecture.core.usecase.DeleteCustomerByIdUseCase;
import com.asilva.springbootcleanarchitecture.core.usecase.FindCustomerByIdUseCase;
import com.asilva.springbootcleanarchitecture.core.usecase.InsertCustomerUseCase;
import com.asilva.springbootcleanarchitecture.core.usecase.UpdateCustomerByIdUseCase;
import com.asilva.springbootcleanarchitecture.entrypoint.controller.mapper.CustomerMapper;
import com.asilva.springbootcleanarchitecture.entrypoint.dto.request.CustomerRequestDto;
import com.asilva.springbootcleanarchitecture.entrypoint.dto.response.CustomerResponseDto;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

	private final InsertCustomerUseCase insertCustomerUseCase;
	private final FindCustomerByIdUseCase findCustomerByIdUseCase;
	private final UpdateCustomerByIdUseCase updateCustomerUseCase;
	private final DeleteCustomerByIdUseCase deleteCustomerByIdUseCase;
	private final CustomerMapper customerMapper;

	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequestDto request) {
		Customer customer = customerMapper.toDomain(request);
		insertCustomerUseCase.insert(customer, request.getZipCode());

		return ResponseEntity.ok().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<CustomerResponseDto> findById(@PathVariable("id") String id) {
		Customer customer = findCustomerByIdUseCase.findById(id);
		CustomerResponseDto response = customerMapper.toResponse(customer);

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(
			@PathVariable("id") String id,
			@Valid @RequestBody CustomerRequestDto request) {
		Customer customer = customerMapper.toDomain(request);

		customer.setId(id);
		updateCustomerUseCase.update(request.getZipCode(), customer);

		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")

	public ResponseEntity<Void> delete(@PathVariable("id") String id) {
		deleteCustomerByIdUseCase.delete(id);

		return ResponseEntity.ok().build();
	}

}
