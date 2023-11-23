package com.asilva.springbootcleanarchitecture.entrypoint.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.asilva.springbootcleanarchitecture.core.domain.Customer;
import com.asilva.springbootcleanarchitecture.core.usecase.UpdateCustomerByIdUseCase;
import com.asilva.springbootcleanarchitecture.entrypoint.consumer.mapper.CustomerMessageMapper;
import com.asilva.springbootcleanarchitecture.entrypoint.consumer.message.CustomerMessage;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ReceiveValidatedCpfConsumer {

	private final UpdateCustomerByIdUseCase updateCustomerByIdUseCase;
	private final CustomerMessageMapper customerMessageMapper;

	@KafkaListener(topics = "cpf-validation", groupId = "cleanarch")
	public void receive(CustomerMessage customerMessage) {
		Customer customer = customerMessageMapper.toDomain(customerMessage);
		updateCustomerByIdUseCase.update(customerMessage.getZipCode(), customer);
	}

}
