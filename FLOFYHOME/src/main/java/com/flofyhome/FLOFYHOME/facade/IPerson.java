package com.flofyhome.FLOFYHOME.facade;

import java.util.List;

import com.flofyhome.FLOFYHOME.model.Person;

public interface IPerson {
	
	public List<Person> findAll();
	
	public Person create(Person person);
	
	public void  update(Person person);
	
	public Person findId(int id);
	
	
}
