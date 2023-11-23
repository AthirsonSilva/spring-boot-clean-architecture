package com.asilva.springbootcleanarchitecture.dataprovider.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.asilva.springbootcleanarchitecture.core.domain.Customer;
import com.asilva.springbootcleanarchitecture.dataprovider.persistence.entity.CustomerEntity;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

	@Mapping(target = "id", ignore = true)
	public CustomerEntity toEntity(final Customer address);

	public Customer toDomain(final CustomerEntity addressEntity);

}
