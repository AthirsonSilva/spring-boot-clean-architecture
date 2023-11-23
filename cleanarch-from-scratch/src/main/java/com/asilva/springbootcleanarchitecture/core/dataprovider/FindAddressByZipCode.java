package com.asilva.springbootcleanarchitecture.core.dataprovider;

import com.asilva.springbootcleanarchitecture.core.domain.Address;

public interface FindAddressByZipCode {

	public Address find(final String zipCode);

}
