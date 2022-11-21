package com.flofyhome.FLOFYHOME.facade;

import java.util.List;

import com.flofyhome.FLOFYHOME.model.Batch;

public interface IBatch {

	public List<Batch> findAll(String keyWord);
	
	public void create(Batch batch);
	
	public void update (Batch batch);
	
	public Batch findId(int id);
}
