package com.asilva.springbootcleanarchitecture.core.usecase;

import com.asilva.springbootcleanarchitecture.core.domain.Customer;

public interface UpdateCustomerByIdUseCase {

	public void update(final String cep, final Customer customer);

}
