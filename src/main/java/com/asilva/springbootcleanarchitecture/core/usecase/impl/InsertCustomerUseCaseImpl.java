package com.asilva.springbootcleanarchitecture.core.usecase.impl;

import com.asilva.springbootcleanarchitecture.core.dataprovider.FindAddressByZipCode;
import com.asilva.springbootcleanarchitecture.core.dataprovider.InsertCustomer;
import com.asilva.springbootcleanarchitecture.core.domain.Address;
import com.asilva.springbootcleanarchitecture.core.domain.Customer;
import com.asilva.springbootcleanarchitecture.core.usecase.InsertCustomerUseCase;

public class InsertCustomerUseCaseImpl implements InsertCustomerUseCase {

	private final FindAddressByZipCode findAddressByZipCode;
	private final InsertCustomer insertCustomer;

	public InsertCustomerUseCaseImpl(FindAddressByZipCode findAddressByZipCode, InsertCustomer insertCustomer) {
		this.findAddressByZipCode = findAddressByZipCode;
		this.insertCustomer = insertCustomer;
	}

	@Override
	public void insert(Customer customer, String cep) {
		Address address = findAddressByZipCode.find(cep);
		customer.setAddress(address);

		insertCustomer.insert(customer, cep);
	}

}
