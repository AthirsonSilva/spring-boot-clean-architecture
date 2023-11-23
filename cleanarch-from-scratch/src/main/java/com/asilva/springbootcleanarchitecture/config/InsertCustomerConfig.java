package com.asilva.springbootcleanarchitecture.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.asilva.springbootcleanarchitecture.core.usecase.InsertCustomerUseCase;
import com.asilva.springbootcleanarchitecture.core.usecase.impl.InsertCustomerUseCaseImpl;
import com.asilva.springbootcleanarchitecture.dataprovider.impl.FindAddressByZipCodeImpl;
import com.asilva.springbootcleanarchitecture.dataprovider.impl.InsertCustomerImpl;

@Configuration
public class InsertCustomerConfig {

	@Bean
	protected InsertCustomerUseCase insertCustomer(
			FindAddressByZipCodeImpl findAddressByZipCodeImpl,
			InsertCustomerImpl insertCustomerImpl) {
		return new InsertCustomerUseCaseImpl(findAddressByZipCodeImpl, insertCustomerImpl);
	}

}
