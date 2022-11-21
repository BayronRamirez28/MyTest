package com.flofyhome.FLOFYHOME.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flofyhome.FLOFYHOME.implement.PersonDao;
import com.flofyhome.FLOFYHOME.model.Person;

@RestController
@RequestMapping(value = "/personas")
@CrossOrigin("*")
public class PersonController {

	@Autowired
	private PersonDao personDao;

	@GetMapping("/all")
	public List<Person> findAll(){
		return personDao.findAll();
	}
	
	@PostMapping("/save")
	public Person save(@RequestBody Person person) throws Exception{
		
		return personDao.create(person);
	}

}
