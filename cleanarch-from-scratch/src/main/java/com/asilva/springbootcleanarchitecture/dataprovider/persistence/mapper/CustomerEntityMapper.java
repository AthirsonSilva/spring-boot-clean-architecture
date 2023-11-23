package com.asilva.springbootcleanarchitecture.dataprovider.persistence.mapper;

import org.mapstruct.Mapper;

import com.asilva.springbootcleanarchitecture.core.domain.Customer;
import com.asilva.springbootcleanarchitecture.dataprovider.persistence.entity.CustomerEntity;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

	public CustomerEntity toEntity(final Customer address);

	public Customer toDomain(final CustomerEntity addressEntity);

}
