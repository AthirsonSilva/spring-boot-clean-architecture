package com.asilva.springbootcleanarchitecture.dataprovider.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.asilva.springbootcleanarchitecture.entrypoint.dto.response.AddressResponseDto;

@FeignClient(name = "findAddressByZipCodeClient", url = "${asilva.client.address.url}")
public interface FindAddressByZipCodeClient {

	@GetMapping(value = "/{zipCode}/json")
	public AddressResponseDto find(@PathVariable("zipCode") String zipCode);

}
