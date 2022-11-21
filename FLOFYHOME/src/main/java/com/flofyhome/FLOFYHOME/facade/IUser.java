package com.flofyhome.FLOFYHOME.facade;

import java.util.List;

import com.flofyhome.FLOFYHOME.model.User;

public interface IUser {

	public List<User> findAll();
	
	public User create(User user);
	
	public User update(User user);
	
	public User findId(int id);
	
	public User findByEmail(String email);
}
