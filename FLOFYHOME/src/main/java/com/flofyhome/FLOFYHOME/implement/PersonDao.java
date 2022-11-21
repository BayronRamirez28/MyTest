package com.flofyhome.FLOFYHOME.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flofyhome.FLOFYHOME.facade.IPerson;
import com.flofyhome.FLOFYHOME.model.Person;
import com.flofyhome.FLOFYHOME.repository.PersonRepository;
import com.flofyhome.FLOFYHOME.repository.UserRepository;


@Service
public class PersonDao implements IPerson {

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired 
	private UserRepository userRepository;

	@Override
	public List<Person> findAll() {
		return this.personRepository.findAll();
	}

	@Override
	public Person create(Person person) {
		return this.personRepository.save(person);
		
	}

	@Override
	public void update(Person person) {
		this.personRepository.save(person);
		
	}

	@Override
	public Person findId(int id) {
		return this.personRepository.getOne(id);
	}
	
	
}
