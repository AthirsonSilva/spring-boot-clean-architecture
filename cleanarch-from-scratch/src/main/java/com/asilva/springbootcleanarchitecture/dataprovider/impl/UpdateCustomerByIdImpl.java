package com.asilva.springbootcleanarchitecture.dataprovider.impl;

import org.springframework.stereotype.Component;

import com.asilva.springbootcleanarchitecture.core.dataprovider.UpdateCustomerById;
import com.asilva.springbootcleanarchitecture.core.domain.Customer;
import com.asilva.springbootcleanarchitecture.dataprovider.persistence.entity.CustomerEntity;
import com.asilva.springbootcleanarchitecture.dataprovider.persistence.mapper.CustomerEntityMapper;
import com.asilva.springbootcleanarchitecture.dataprovider.persistence.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UpdateCustomerByIdImpl implements UpdateCustomerById {

	private final CustomerRepository customerRepository;
	private final CustomerEntityMapper customerEntityMapper;

	@Override
	public void update(Customer customer) {
		CustomerEntity customerEntity = customerEntityMapper.toEntity(customer);
		customerRepository.save(customerEntity);
	}

}
