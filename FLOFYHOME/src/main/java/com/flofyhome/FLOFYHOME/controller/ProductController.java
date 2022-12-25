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
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> findId(@PathVariable Integer id){
		return new ResponseEntity<>(productDao.findId(id), HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Product> create(@RequestBody Product product){
		return new ResponseEntity<>(productDao.create(product), HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Product> update(@PathVariable Integer id, @RequestBody Product product){
		Product productFound = productDao.findId(id);
		
		if(productFound == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		try {
			productFound.setName(product.getName());
			productFound.setDetail(product.getDetail());
			productFound.setSale_price(product.getSale_price());
			productFound.setMinimun_quantity(product.getMinimun_quantity());
			productFound.setEstate(product.getEstate());
			productFound.setCategory(product.getCategory());
			productFound.setSupplier(product.getSupplier());
			
			return new ResponseEntity<>(productDao.update(productFound), HttpStatus.CREATED);
		} catch (DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
