package com.sale.charme.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.sale.charme.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {
	
	@Query("{fullName : ?0}")
	Customer findByCustomerFullName(String fullName);

}
