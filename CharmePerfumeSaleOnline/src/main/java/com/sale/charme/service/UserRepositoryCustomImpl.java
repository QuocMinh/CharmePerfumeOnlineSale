package com.sale.charme.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sale.charme.dao.UserRepositoryCustom;
import com.sale.charme.model.User;

public class UserRepositoryCustomImpl implements UserRepositoryCustom {
	
	@Override
	public Page<User> findAllPageable(Pageable pageable) {
		return null;
	}

}
