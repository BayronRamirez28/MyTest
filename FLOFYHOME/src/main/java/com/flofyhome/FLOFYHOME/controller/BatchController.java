package com.flofyhome.FLOFYHOME.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
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

import com.flofyhome.FLOFYHOME.implement.BatchDao;
import com.flofyhome.FLOFYHOME.implement.ProductDao;
import com.flofyhome.FLOFYHOME.model.Batch;
import com.flofyhome.FLOFYHOME.model.Product;

@Controller
@RequestMapping("/lotes")
@CrossOrigin("*")
public class BatchController {

	@Autowired
	private BatchDao batchDao;

	@Autowired
	private ProductDao productDao;

	@GetMapping("/all")
	public ResponseEntity<List<Batch>> findAll() {
		return new ResponseEntity<>(batchDao.findAll(), HttpStatus.OK);
	}

	@GetMapping("/productos")
	public ResponseEntity<List<Product>> listarProductos() {
		return new ResponseEntity<>(productDao.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Batch> findId(@PathVariable Integer id) {
		return new ResponseEntity<>(batchDao.findId(id), HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<Batch> create(@RequestBody Batch batch) {
		return new ResponseEntity<>(batchDao.create(batch), HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Batch> update(@PathVariable Integer id, @RequestBody Batch batch){
		Batch batchFound = batchDao.findId(id);
	
	if(batchFound == null) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	try {
		batchFound.setQuantity(batch.getQuantity());
		batchFound.setPrice_shopping(batch.getPrice_shopping());
		batchFound.setRegistration_date(batch.getRegistration_date());
		batchFound.setExpiration_date(batch.getExpiration_date());
		batchFound.setProduct(batch.getProduct());
		
		return new ResponseEntity<>(batchDao.update(batchFound), HttpStatus.CREATED);
	} catch (DataAccessException e) {
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
}
