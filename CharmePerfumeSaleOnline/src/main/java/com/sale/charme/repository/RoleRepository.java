package com.sale.charme.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.sale.charme.model.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
	
	@Query("{roleName : ?0}")
	public Role findByRoleName(String roleName);

}
