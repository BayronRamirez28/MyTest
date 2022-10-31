package com.flofyhome.FLOFYHOME.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flofyhome.FLOFYHOME.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {


	@Query("SELECT p FROM Product p WHERE" 
	+ " CONCAT(p.name, p.detail, p.supplier, p.category)"
	+ " LIKE %?1%")
	public List<Product> findAll(String keyWord);
}
