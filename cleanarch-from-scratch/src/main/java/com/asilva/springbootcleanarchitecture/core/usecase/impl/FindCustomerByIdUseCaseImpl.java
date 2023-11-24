package com.asilva.springbootcleanarchitecture.core.usecase.impl;

import com.asilva.springbootcleanarchitecture.core.dataprovider.FindCustomerById;
import com.asilva.springbootcleanarchitecture.core.domain.Customer;
import com.asilva.springbootcleanarchitecture.core.usecase.FindCustomerByIdUseCase;

public class FindCustomerByIdUseCaseImpl implements FindCustomerByIdUseCase {

	private final FindCustomerById findCustomerById;

	public FindCustomerByIdUseCaseImpl(final FindCustomerById findCustomerById) {
		this.findCustomerById = findCustomerById;
	}

	@Override
	public Customer findById(String id) {
		return findCustomerById.findById(id)
				.orElseThrow(() -> new RuntimeException("Customer not found"));
	}

}
