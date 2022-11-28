package com.flofyhome.FLOFYHOME.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.flofyhome.FLOFYHOME.implement.ProductDao;
import com.flofyhome.FLOFYHOME.implement.SupplierDao;
import com.flofyhome.FLOFYHOME.model.Category;
import com.flofyhome.FLOFYHOME.model.Product;
import com.flofyhome.FLOFYHOME.model.Supplier;




@Controller
@RequestMapping("/productos")
@CrossOrigin("*")
public class ProductController {
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private SupplierDao supplierDao;
	
	@Autowired
	private CategoryDao categoryDao;

	@GetMapping("/all")
	public ResponseEntity<List<Product>> findAll(){
		return new ResponseEntity<>(productDao.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/categorias")
	public ResponseEntity<List<Category>> listarCategorias(){
		return new ResponseEntity<>(categoryDao.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/proveedores")
	public ResponseEntity<List<Supplier>> listarProveedores(){
		return new ResponseEntity<>(supplierDao.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Product> create(@RequestBody Product product){
		return new ResponseEntity<>(productDao.create(product), HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Product> update(@RequestBody Product product){
		return ResponseEntity.ok(productDao.update(product));
	}

	@GetMapping("/{id}")
	public Product findId(@PathVariable("id") int id){
		return productDao.findId(id);
	}
	

}
