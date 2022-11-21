package com.flofyhome.FLOFYHOME.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flofyhome.FLOFYHOME.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByEmail(String email);
}
