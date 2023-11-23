package com.asilva.springbootcleanarchitecture.entrypoint.consumer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.asilva.springbootcleanarchitecture.core.domain.Customer;
import com.asilva.springbootcleanarchitecture.entrypoint.consumer.message.CustomerMessage;

@Mapper(componentModel = "spring")
public interface CustomerMessageMapper {

	@Mapping(target = "address", ignore = true)
	Customer toDomain(final CustomerMessage customerMessage);

}
