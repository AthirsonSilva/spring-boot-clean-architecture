package com.asilva.springbootcleanarchitecture.dataprovider.persistence.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "customers")
public class CustomerEntity {

	@Id
	private String id;
	private String name;
	private String cpf;
	private AddressEntity address;
	private Boolean isValidCpf;

}
