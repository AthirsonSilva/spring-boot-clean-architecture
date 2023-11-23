package com.asilva.springbootcleanarchitecture.core.dataprovider;

import com.asilva.springbootcleanarchitecture.core.domain.Customer;

public interface InsertCustomer {

	public void insert(Customer customer, String cep);

}
