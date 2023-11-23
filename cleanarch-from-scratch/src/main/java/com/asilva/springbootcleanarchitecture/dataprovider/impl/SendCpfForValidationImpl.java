package com.asilva.springbootcleanarchitecture.dataprovider.impl;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.asilva.springbootcleanarchitecture.core.dataprovider.SendCpForValidation;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SendCpfForValidationImpl implements SendCpForValidation {

	private final KafkaTemplate<String, String> kafkaTemplate;

	@Override
	public void send(String cpf) {
		kafkaTemplate.send("cpf-validation", cpf);
	}

}
