package com.flofyhome.FLOFYHOME.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flofyhome.FLOFYHOME.implement.CategoryDao;
import com.flofyhome.FLOFYHOME.model.Category;


@Controller
@RequestMapping("/categorias")
@CrossOrigin("*")
public class CategoryController {
	
	@Autowired
	private CategoryDao categoryDao;
	
	@GetMapping("/all")
	public ResponseEntity<List<Category>> findAll(){
		return new ResponseEntity<>(categoryDao.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> findId(@PathVariable Integer id){
		return new ResponseEntity<>(categoryDao.findId(id), HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Category> create(@RequestBody Category category){
		return new ResponseEntity<>(categoryDao.create(category), HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Category> update(@PathVariable Integer id ,@RequestBody Category category){
		Category categoryFound = categoryDao.findId(id);
		
		if(categoryFound == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		try {
			categoryFound.setName(category.getName());
			
			return new ResponseEntity<>(categoryDao.update(categoryFound), HttpStatus.CREATED);
		} catch (DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
		
}
