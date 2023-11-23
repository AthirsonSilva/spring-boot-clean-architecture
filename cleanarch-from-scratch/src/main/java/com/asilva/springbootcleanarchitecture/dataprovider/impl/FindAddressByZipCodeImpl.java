package com.asilva.springbootcleanarchitecture.dataprovider.impl;

import org.springframework.stereotype.Component;

import com.asilva.springbootcleanarchitecture.core.dataprovider.FindAddressByZipCode;
import com.asilva.springbootcleanarchitecture.core.domain.Address;
import com.asilva.springbootcleanarchitecture.dataprovider.client.FindAddressByZipCodeClient;
import com.asilva.springbootcleanarchitecture.dataprovider.client.mapper.AddressResponseMapper;
import com.asilva.springbootcleanarchitecture.entrypoint.dto.response.AddressResponseDto;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FindAddressByZipCodeImpl implements FindAddressByZipCode {

	private final FindAddressByZipCodeClient findAddressByZipCodeClient;
	private final AddressResponseMapper addressResponseMapper;

	@Override
	public Address find(String zipCode) {
		AddressResponseDto addressResponse = findAddressByZipCodeClient.find(zipCode);
		return addressResponseMapper.toDomain(addressResponse);
	}

}
