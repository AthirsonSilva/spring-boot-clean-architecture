package com.asilva.springbootcleanarchitecture.entrypoint.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerRequestDto {

	@NotBlank(message = "Name is required")
	private String name;

	@NotBlank(message = "CPF is required")
	@Size(min = 11, max = 11, message = "CPF must be 11 characters")
	private String cpf;

	@NotBlank(message = "Street is required")
	private String zipCode;

}
