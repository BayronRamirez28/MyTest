package com.flofyhome.FLOFYHOME.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flofyhome.FLOFYHOME.implement.RoleDao;
import com.flofyhome.FLOFYHOME.model.Role;


@RestController
@RequestMapping(value = "/roles")
@CrossOrigin("*")
public class RoleController {

	@Autowired
	private RoleDao roleDao;
	
	@GetMapping("/all")
	public List<Role> findAll(){
		return roleDao.findAll();
	}
}
