package com.asilva.springbootcleanarchitecture.dataprovider.impl;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.asilva.springbootcleanarchitecture.core.dataprovider.FindCustomerById;
import com.asilva.springbootcleanarchitecture.core.domain.Customer;
import com.asilva.springbootcleanarchitecture.dataprovider.persistence.entity.CustomerEntity;
import com.asilva.springbootcleanarchitecture.dataprovider.persistence.mapper.CustomerEntityMapper;
import com.asilva.springbootcleanarchitecture.dataprovider.persistence.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FindCustomerByIdImpl implements FindCustomerById {

	private final CustomerRepository customerRepository;
	private final CustomerEntityMapper customerEntityMapper;

	@Override
	public Optional<Customer> findById(String id) {
		Optional<CustomerEntity> customer = customerRepository.findById(id);
		return customer.map(customerEntityMapper::toDomain);
	}

}
