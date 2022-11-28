package com.flofyhome.FLOFYHOME.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	public ResponseEntity<?> findAll(){
		return ResponseEntity.ok(categoryDao.findAll());
	}
	
	@PostMapping("/create")
	public ResponseEntity<Category> create(@RequestBody Category category){
		return ResponseEntity.ok(categoryDao.create(category));
	}
	
	@PutMapping("/update")
	public ResponseEntity<Category> update(@RequestBody Category category){
		return ResponseEntity.ok(categoryDao.update(category));
	}
	
	@GetMapping("/{id}")
	public Category findId(@PathVariable("id") int id) {
		return categoryDao.findId(id);
	}
		
}
