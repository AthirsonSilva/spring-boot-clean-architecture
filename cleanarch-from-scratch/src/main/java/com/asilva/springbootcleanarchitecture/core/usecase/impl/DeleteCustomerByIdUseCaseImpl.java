package com.asilva.springbootcleanarchitecture.core.usecase.impl;

import com.asilva.springbootcleanarchitecture.core.dataprovider.DeleteCustomerById;
import com.asilva.springbootcleanarchitecture.core.usecase.DeleteCustomerByIdUseCase;
import com.asilva.springbootcleanarchitecture.core.usecase.FindCustomerByIdUseCase;

public class DeleteCustomerByIdUseCaseImpl implements DeleteCustomerByIdUseCase {

	private final FindCustomerByIdUseCase findCustomerByIdUseCase;
	private final DeleteCustomerById deleteCustomerById;

	public DeleteCustomerByIdUseCaseImpl(
			final FindCustomerByIdUseCase findCustomerByIdUseCase,
			final DeleteCustomerById deleteCustomerById) {
		this.findCustomerByIdUseCase = findCustomerByIdUseCase;
		this.deleteCustomerById = deleteCustomerById;
	}

	@Override
	public void delete(String id) {
		findCustomerByIdUseCase.findById(id);
		deleteCustomerById.delete(id);
	}

}
