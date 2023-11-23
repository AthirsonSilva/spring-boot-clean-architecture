package com.asilva.springbootcleanarchitecture.entrypoint.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.asilva.springbootcleanarchitecture.core.domain.Customer;
import com.asilva.springbootcleanarchitecture.entrypoint.dto.request.CustomerRequestDto;
import com.asilva.springbootcleanarchitecture.entrypoint.dto.response.CustomerResponseDto;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

	@Mappings({
			@Mapping(target = "id", ignore = true),
			@Mapping(target = "address", ignore = true),
			@Mapping(target = "isValidCpf", ignore = true),
	})
	public Customer toDomain(final CustomerRequestDto customer);

	public CustomerResponseDto toResponse(final Customer customer);

}
