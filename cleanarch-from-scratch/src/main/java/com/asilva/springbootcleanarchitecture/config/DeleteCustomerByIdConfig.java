package com.asilva.springbootcleanarchitecture.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.asilva.springbootcleanarchitecture.core.usecase.DeleteCustomerByIdUseCase;
import com.asilva.springbootcleanarchitecture.core.usecase.FindCustomerByIdUseCase;
import com.asilva.springbootcleanarchitecture.core.usecase.impl.DeleteCustomerByIdUseCaseImpl;
import com.asilva.springbootcleanarchitecture.dataprovider.impl.DeleteCustomerByIdImpl;

@Configuration
public class DeleteCustomerByIdConfig {

	@Bean
	protected DeleteCustomerByIdUseCase deleteCustomerById(DeleteCustomerByIdImpl deleteCustomerByIdImpl,
			FindCustomerByIdUseCase findCustomerByIdUseCase) {
		return new DeleteCustomerByIdUseCaseImpl(findCustomerByIdUseCase, deleteCustomerByIdImpl);
	}

}
