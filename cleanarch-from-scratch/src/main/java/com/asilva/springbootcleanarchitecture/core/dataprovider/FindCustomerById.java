package com.asilva.springbootcleanarchitecture.core.dataprovider;

import java.util.Optional;

import com.asilva.springbootcleanarchitecture.core.domain.Customer;

public interface FindCustomerById {

	public Optional<Customer> findById(final String id);

}
