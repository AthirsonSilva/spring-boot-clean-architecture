package com.asilva.springbootcleanarchitecture.core.usecase;

import com.asilva.springbootcleanarchitecture.core.domain.Customer;

public interface FindCustomerByIdUseCase {

	public Customer findById(final String id);

}
