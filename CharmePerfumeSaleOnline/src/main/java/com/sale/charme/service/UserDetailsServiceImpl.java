package com.sale.charme.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sale.charme.model.Role;
import com.sale.charme.model.User;
import com.sale.charme.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = userRepository.findOne(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("User not found!");
		}
		System.out.println("-----------> " + user.toString());
		
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		List<Role> roles = user.getUserRole();
		
		for (Role role : roles) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		}
		
		return new org.springframework.security.core.userdetails.User(
				user.getUsername(), 
				user.getPassword(), 
				grantedAuthorities);
	}
	
}
