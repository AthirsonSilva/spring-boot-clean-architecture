package com.cleanarch.infrastructure.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.cleanarch.infrastructure.persistence.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

}
