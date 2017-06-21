package com.sale.charme.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sale.charme.model.User;

public interface UserRepositoryCustom {

	Page<User> findAllPageable(Pageable pageable);
	
}
