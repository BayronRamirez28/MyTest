package com.flofyhome.FLOFYHOME.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flofyhome.FLOFYHOME.model.Batch;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Integer> {

	@Query("SELECT b, p FROM Batch b join Product p on b.product=p.id WHERE" 
	+ " CONCAT(b.id, p.name)" 
	+ " LIKE %?1%")
	public List<Batch> findAll(String keyWord);
}
