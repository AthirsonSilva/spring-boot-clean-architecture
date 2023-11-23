package com.asilva.springbootcleanarchitecture.core.usecase.impl;

import com.asilva.springbootcleanarchitecture.core.dataprovider.FindAddressByZipCode;
import com.asilva.springbootcleanarchitecture.core.dataprovider.UpdateCustomerById;
import com.asilva.springbootcleanarchitecture.core.domain.Address;
import com.asilva.springbootcleanarchitecture.core.domain.Customer;
import com.asilva.springbootcleanarchitecture.core.usecase.FindCustomerByIdUseCase;
import com.asilva.springbootcleanarchitecture.core.usecase.UpdateCustomerByIdUseCase;

public class UpdateCustomerByIdUseCaseImpl implements UpdateCustomerByIdUseCase {

	private final FindCustomerByIdUseCase findCustomerByIdUseCase;
	private final FindAddressByZipCode findAddressByZipCode;
	private final UpdateCustomerById updateCustomer;

	public UpdateCustomerByIdUseCaseImpl(
			final FindCustomerByIdUseCase findCustomerByIdUseCase,
			final FindAddressByZipCode findAddressByZipCode,
			final UpdateCustomerById updateCustomer) {
		this.findCustomerByIdUseCase = findCustomerByIdUseCase;
		this.findAddressByZipCode = findAddressByZipCode;
		this.updateCustomer = updateCustomer;
	}

	@Override
	public void update(String cep, Customer customer) {
		Customer foundCustomer = findCustomerByIdUseCase.findById(customer.getId());
		Address foundAddress = findAddressByZipCode.find(cep);

		foundCustomer.setAddress(foundAddress);
		foundCustomer.setName(customer.getName());
		foundCustomer.setCpf(customer.getCpf());

		updateCustomer.update(foundCustomer);
	}

}
