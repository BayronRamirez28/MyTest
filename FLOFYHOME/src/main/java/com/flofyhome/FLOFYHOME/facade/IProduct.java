package com.flofyhome.FLOFYHOME.facade;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.flofyhome.FLOFYHOME.model.Product;

public interface IProduct {

	public List<Product> findAll();
	
	public Product create(Product product);

	public Product update(Product product);
	
	public Product findId(int id);
	
	
}
