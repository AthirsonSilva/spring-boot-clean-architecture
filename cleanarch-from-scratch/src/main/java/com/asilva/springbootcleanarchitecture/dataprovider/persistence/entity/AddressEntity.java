package com.asilva.springbootcleanarchitecture.dataprovider.persistence.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "addresses")
public class AddressEntity {

	@Id
	private String id;
	private String street;
	private String city;
	private String state;

}
