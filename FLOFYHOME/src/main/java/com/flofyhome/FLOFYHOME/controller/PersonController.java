package com.flofyhome.FLOFYHOME.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flofyhome.FLOFYHOME.implement.PersonDao;
import com.flofyhome.FLOFYHOME.model.Person;

@Controller
@RequestMapping("/persons")
public class PersonController {

	@Autowired
	private PersonDao personDao;

	@GetMapping("/all")
	public ResponseEntity<Map<String, Object>> allPerson() {
		List<Person> listPersons = this.personDao.findAll();
		Map<String, Object> respon = new HashMap<String, Object>();
		respon.put("data", listPersons);
		return new ResponseEntity<>(respon, HttpStatus.OK);

	}

	@PostMapping("/create")
	public ResponseEntity<Map<String, Object>> createPerson() {
		List<Person> listPersons = this.personDao.findAll();
		Map<String, Object> respon = new HashMap<String, Object>();
		Person person = new Person();
		person.setId((int) respon.get("id"));
		person.setName((String) respon.get("name"));
		person.setLastname((String) respon.get("lastname"));
		person.setDocument_type((String) respon.get("document_type"));
		person.setDni((String) respon.get("dni"));
		person.setCellphone((long) respon.get("cellphone"));
		person.setTelephone((long) respon.get("telephone"));
		respon.put("data", listPersons);
		respon.put("message", "Creación exitosa");
		return new ResponseEntity<>(respon, HttpStatus.OK);

	}

	@PutMapping
	public void update(@RequestBody Person person) {
		personDao.update(person);
	}

}
