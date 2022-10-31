package com.flofyhome.FLOFYHOME.facade;

import java.util.List;

import com.flofyhome.FLOFYHOME.model.Product;

public interface IProduct {

	public List<Product> findAll(String keyWord);

	public void create(Product product);

	public void update(Product product);
	
	public Product findId(int id);
	

}
