package com.ems.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ems.entity.UserEntity;
import com.ems.repository.UserRepository;

@Service
public class CheckUserDetailsService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	       UserEntity user =  this.userRepository.findByEmail(username).orElseThrow(null);
		return user;
	}

}
