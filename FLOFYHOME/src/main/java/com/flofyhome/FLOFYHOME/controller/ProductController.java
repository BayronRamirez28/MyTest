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
	public ResponseEntity<?> findAll(){
		return ResponseEntity.ok(productDao.findAll());
	}
	
	@GetMapping("/categorias")
	public ResponseEntity<?> listarCategorias(){
		return ResponseEntity.ok(categoryDao.findAll());
	}
	
	@GetMapping("/proveedores")
	public ResponseEntity<?> listarProveedores(){
		return ResponseEntity.ok(supplierDao.findAll());
	}
	
	@PostMapping("/create")
	public ResponseEntity<Product> create(@RequestBody Product product){
		return ResponseEntity.ok(productDao.create(product));
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
