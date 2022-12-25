package com.flofyhome.FLOFYHOME.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flofyhome.FLOFYHOME.facade.IBatch;
import com.flofyhome.FLOFYHOME.model.Batch;
import com.flofyhome.FLOFYHOME.repository.BatchRepository;

@Service
public class BatchDao implements IBatch{
	
	@Autowired
	private BatchRepository batchRepository;
	
	@Override
	public List<Batch> findAll(){
		return new ArrayList<>(batchRepository.findAll());
	}
	
	@Override
	public Batch create(Batch batch) {
		return batchRepository.save(batch);
	}
	
	@Override
	public Batch update(Batch batch) {
		return batchRepository.save(batch);
	}
	
	@Override
	public Batch findId(int id) {
		return batchRepository.findById(id).get();
	}
	
}
