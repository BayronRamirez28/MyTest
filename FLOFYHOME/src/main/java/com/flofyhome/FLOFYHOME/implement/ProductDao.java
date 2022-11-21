package com.flofyhome.FLOFYHOME.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.flofyhome.FLOFYHOME.facade.IProduct;
import com.flofyhome.FLOFYHOME.model.Product;
import com.flofyhome.FLOFYHOME.repository.ProductRepository;

@Service
public class ProductDao implements IProduct {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> findAll() {
		return new ArrayList<>(productRepository.findAll());
	}

	@Override
	public Product create(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product update(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product findId(int id) {
		return productRepository.findById(id).get();
	}



}
