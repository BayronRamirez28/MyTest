package com.flofyhome.FLOFYHOME.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.flofyhome.FLOFYHOME.model.User;
import com.flofyhome.FLOFYHOME.repository.UserRepository;

@Service
public class UserDetailsServiceDao implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = this.userRepository.findByEmail(email);
		if( user == null) {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		return user;
	}

	
}
