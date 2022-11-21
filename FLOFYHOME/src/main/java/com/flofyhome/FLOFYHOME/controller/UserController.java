package com.flofyhome.FLOFYHOME.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flofyhome.FLOFYHOME.implement.UserDao;
import com.flofyhome.FLOFYHOME.model.User;

@RestController
@RequestMapping(value = "/usuarios")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	@GetMapping("/all")
	public List<User> findAll(){
		return userDao.findAll();
	}
	
	@PostMapping("/save")
	public User save(@RequestBody User user) throws Exception{
		
		
		return userDao.create(user);
	}
	
	 @GetMapping("/{email}")
	    public User findByEmail(@PathVariable("email") String email){
	        return userDao.findByEmail(email);
	    }
}
