package com.asilva.springbootcleanarchitecture.dataprovider.impl;

import org.springframework.stereotype.Component;

import com.asilva.springbootcleanarchitecture.core.dataprovider.DeleteCustomerById;
import com.asilva.springbootcleanarchitecture.dataprovider.persistence.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DeleteCustomerByIdImpl implements DeleteCustomerById {

	private final CustomerRepository customerRepository;

	@Override
	public void delete(String id) {
		customerRepository.deleteById(id);
	}

}
