package com.asilva.springbootcleanarchitecture.dataprovider.persistence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.asilva.springbootcleanarchitecture.dataprovider.persistence.entity.CustomerEntity;

@Repository
public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {

}
