package com.flofyhome.FLOFYHOME.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flofyhome.FLOFYHOME.implement.SupplierDao;
import com.flofyhome.FLOFYHOME.model.Category;
import com.flofyhome.FLOFYHOME.model.Supplier;

@RestController
@RequestMapping(value = "/proveedores")
@CrossOrigin("*")
public class SupplierController {
	
	@Autowired
	private SupplierDao supplierDao;

	@GetMapping("/all")
	public ResponseEntity<?> findAll(){
		return ResponseEntity.ok(supplierDao.findAll());
	}
	
	@PostMapping("/create")
	public ResponseEntity<Supplier> create(@RequestBody Supplier supplier){
		return ResponseEntity.ok(supplierDao.create(supplier));
	}
	
	@PutMapping("/update")
	public ResponseEntity<Supplier> update(@RequestBody Supplier supplier){
		return ResponseEntity.ok(supplierDao.update(supplier));
	}
	
	@GetMapping("/{id}")
	public Supplier findId(@PathVariable("id") int id) {
		return supplierDao.findId(id);
	}
		
	
}
