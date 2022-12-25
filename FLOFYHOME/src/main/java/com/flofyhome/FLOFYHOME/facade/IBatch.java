package com.flofyhome.FLOFYHOME.facade;

import java.util.List;

import com.flofyhome.FLOFYHOME.model.Batch;

public interface IBatch {

	public List<Batch> findAll();
	
	public Batch create(Batch batch);
	
	public Batch update (Batch batch);
	
	public Batch findId(int id);
}
