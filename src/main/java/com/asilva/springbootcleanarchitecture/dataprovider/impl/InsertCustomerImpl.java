package com.asilva.springbootcleanarchitecture.dataprovider.impl;

import org.springframework.stereotype.Component;

import com.asilva.springbootcleanarchitecture.core.dataprovider.InsertCustomer;
import com.asilva.springbootcleanarchitecture.core.domain.Customer;
import com.asilva.springbootcleanarchitecture.dataprovider.persistence.entity.CustomerEntity;
import com.asilva.springbootcleanarchitecture.dataprovider.persistence.mapper.CustomerEntityMapper;
import com.asilva.springbootcleanarchitecture.dataprovider.persistence.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InsertCustomerImpl implements InsertCustomer {

	private final CustomerRepository customerRepository;
	private final CustomerEntityMapper customerEntityMapper;

	@Override
	public void insert(Customer customer, String cep) {
		CustomerEntity customerEntity = customerEntityMapper.toEntity(customer);
		customerRepository.save(customerEntity);
	}

}
