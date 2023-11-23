package com.asilva.springbootcleanarchitecture.core.usecase;

import com.asilva.springbootcleanarchitecture.core.domain.Customer;

public interface InsertCustomerUseCase {

	public void insert(Customer customer, String cep);

}
