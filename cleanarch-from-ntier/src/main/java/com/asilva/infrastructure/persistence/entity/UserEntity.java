package com.cleanarch.infrastructure.persistence.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table("USER")
public class UserEntity {

	@Id
	private Long id;
	private String username;
	private String password;
	private String email;

}
