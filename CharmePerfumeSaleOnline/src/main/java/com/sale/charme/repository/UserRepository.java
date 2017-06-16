package com.sale.charme.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sale.charme.model.User;

public interface UserRepository extends MongoRepository<User, String> {
	
}
