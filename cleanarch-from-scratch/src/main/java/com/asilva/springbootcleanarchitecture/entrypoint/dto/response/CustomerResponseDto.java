package com.asilva.springbootcleanarchitecture.entrypoint.dto.response;

import lombok.Data;

@Data
public class CustomerResponseDto {

	private String id;
	private String name;
	private String cpf;
	private Boolean isValidCpf;
	private AddressResponseDto address;

}
