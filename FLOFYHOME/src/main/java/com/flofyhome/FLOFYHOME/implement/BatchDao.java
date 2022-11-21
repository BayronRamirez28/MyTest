package com.flofyhome.FLOFYHOME.implement;

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
	public List<Batch> findAll(String keyWord){
		if(keyWord != null) {
			return this.batchRepository.findAll(keyWord);
		}
		return this.batchRepository.findAll();
	}
	
	@Override
	public void create(Batch batch) {
		this.batchRepository.save(batch);
	}
	
	@Override
	public void update(Batch batch) {
		this.batchRepository.save(batch);
	}
	
	@Override
	public Batch findId(int id) {
		return this.batchRepository.getOne(id);
	}
	
}
