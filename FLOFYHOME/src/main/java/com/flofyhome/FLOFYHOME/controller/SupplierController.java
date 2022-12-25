package com.flofyhome.FLOFYHOME.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flofyhome.FLOFYHOME.implement.SupplierDao;
import com.flofyhome.FLOFYHOME.model.Supplier;

@RestController
@RequestMapping(value = "/proveedores")
@CrossOrigin("*")
public class SupplierController {
	
	@Autowired
	private SupplierDao supplierDao;

	@GetMapping("/all")
	public ResponseEntity<List<Supplier>> findAll(){
		return new ResponseEntity<>(supplierDao.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Supplier> findId(@PathVariable Integer id){
		return new ResponseEntity<>(supplierDao.findId(id), HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Supplier> create(@RequestBody Supplier supplier){
		return new ResponseEntity<>(supplierDao.create(supplier), HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Supplier> update(@PathVariable Integer id,@RequestBody Supplier supplier){
		Supplier supplierFound = supplierDao.findId(id);
		
		if(supplierFound == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		try {
			supplierFound.setName(supplier.getName());
			supplierFound.setEmail(supplier.getEmail());
			supplierFound.setTelephone(supplier.getTelephone());
			
			return new ResponseEntity<>(supplierDao.update(supplierFound), HttpStatus.CREATED);
		} catch (DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
		
	
}
