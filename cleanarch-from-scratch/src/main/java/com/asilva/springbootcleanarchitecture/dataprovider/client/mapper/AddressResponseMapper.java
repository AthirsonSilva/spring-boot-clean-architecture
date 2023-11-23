package com.asilva.springbootcleanarchitecture.dataprovider.client.mapper;

import org.mapstruct.Mapper;

import com.asilva.springbootcleanarchitecture.core.domain.Address;
import com.asilva.springbootcleanarchitecture.entrypoint.dto.response.AddressResponseDto;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

	public Address toDomain(final AddressResponseDto addressResponse);

}
