package com.asilva.springbootcleanarchitecture.core.usecase.impl;

import com.asilva.springbootcleanarchitecture.core.dataprovider.FindAddressByZipCode;
import com.asilva.springbootcleanarchitecture.core.dataprovider.InsertCustomer;
import com.asilva.springbootcleanarchitecture.core.dataprovider.SendCpForValidation;
import com.asilva.springbootcleanarchitecture.core.domain.Address;
import com.asilva.springbootcleanarchitecture.core.domain.Customer;
import com.asilva.springbootcleanarchitecture.core.usecase.InsertCustomerUseCase;

public class InsertCustomerUseCaseImpl implements InsertCustomerUseCase {

	private final FindAddressByZipCode findAddressByZipCode;
	private final InsertCustomer insertCustomer;
	private final SendCpForValidation sendCpForValidation;

	public InsertCustomerUseCaseImpl(FindAddressByZipCode findAddressByZipCode,
			InsertCustomer insertCustomer,
			SendCpForValidation sendCpForValidation) {
		this.findAddressByZipCode = findAddressByZipCode;
		this.insertCustomer = insertCustomer;
		this.sendCpForValidation = sendCpForValidation;
	}

	@Override
	public void insert(Customer customer, String cep) {
		Address address = findAddressByZipCode.find(cep);
		customer.setAddress(address);
		insertCustomer.insert(customer, cep);
		sendCpForValidation.send(customer.getCpf());
	}

}
