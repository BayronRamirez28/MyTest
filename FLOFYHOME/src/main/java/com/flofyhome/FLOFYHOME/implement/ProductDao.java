package com.flofyhome.FLOFYHOME.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flofyhome.FLOFYHOME.facade.IProduct;
import com.flofyhome.FLOFYHOME.model.Product;
import com.flofyhome.FLOFYHOME.repository.ProductRepository;

@Service
public class ProductDao implements IProduct {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> findAll(String keyWord) {
		if(keyWord != null) {
			return this.productRepository.findAll(keyWord);
			
		}
		return this.productRepository.findAll();
	}

	@Override
	public void create(Product product) {
		this.productRepository.save(product);

	}

	@Override
	public void update(Product product) {
		this.productRepository.save(product);

	}

	@Override
	public Product findId(int id) {
		return this.productRepository.getOne(id);
	}



}
