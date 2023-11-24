package com.asilva.springbootcleanarchitecture.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.asilva.springbootcleanarchitecture.core.usecase.FindCustomerByIdUseCase;
import com.asilva.springbootcleanarchitecture.core.usecase.UpdateCustomerByIdUseCase;
import com.asilva.springbootcleanarchitecture.core.usecase.impl.UpdateCustomerByIdUseCaseImpl;
import com.asilva.springbootcleanarchitecture.dataprovider.impl.FindAddressByZipCodeImpl;
import com.asilva.springbootcleanarchitecture.dataprovider.impl.UpdateCustomerByIdImpl;

@Configuration
public class UpdateCustomerByIdConfig {

	@Bean
	protected UpdateCustomerByIdUseCase updateCustomerById(
			FindCustomerByIdUseCase findCustomerByIdUseCase,
			FindAddressByZipCodeImpl findAddressByZipCodeImpl,
			UpdateCustomerByIdImpl updateCustomerByIdImpl) {
		return new UpdateCustomerByIdUseCaseImpl(findCustomerByIdUseCase, findAddressByZipCodeImpl, updateCustomerByIdImpl);
	}

}
