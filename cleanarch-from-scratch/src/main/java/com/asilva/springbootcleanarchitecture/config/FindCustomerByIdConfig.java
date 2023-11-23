package com.asilva.springbootcleanarchitecture.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.asilva.springbootcleanarchitecture.core.usecase.FindCustomerByIdUseCase;
import com.asilva.springbootcleanarchitecture.core.usecase.impl.FindCustomerByIdUseCaseImpl;
import com.asilva.springbootcleanarchitecture.dataprovider.impl.FindCustomerByIdImpl;

@Configuration
public class FindCustomerByIdConfig {

	@Bean
	protected FindCustomerByIdUseCase findCustomerById(FindCustomerByIdImpl findCustomerByIdImpl) {
		return new FindCustomerByIdUseCaseImpl(findCustomerByIdImpl);
	}

}
