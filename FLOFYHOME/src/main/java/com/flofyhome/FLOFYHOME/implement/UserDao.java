package com.flofyhome.FLOFYHOME.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flofyhome.FLOFYHOME.facade.IUser;
import com.flofyhome.FLOFYHOME.model.User;
import com.flofyhome.FLOFYHOME.repository.RolRepository;
import com.flofyhome.FLOFYHOME.repository.UserRepository;

@Service
public class UserDao implements IUser {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAll() {
		return this.userRepository.findAll();
	}

	@Override
	public User create(User user){
		return this.userRepository.save(user);
		
	}

	@Override
	public User update(User user) {
		return this.userRepository.save(user);
		
	}

	@Override
	public User findId(int id) {
		return this.userRepository.getOne(id);
	}

	@Override
	public User findByEmail(String email) {
		return this.userRepository.findByEmail(email);
	}
	
	
	
	
}
