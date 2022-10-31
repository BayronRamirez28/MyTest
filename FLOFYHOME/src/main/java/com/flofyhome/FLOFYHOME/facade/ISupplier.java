package com.flofyhome.FLOFYHOME.facade;

import java.util.List;

import com.flofyhome.FLOFYHOME.model.Supplier;

public interface ISupplier {

	public List<Supplier> findAll();
	
	public void create(Supplier supplier);
	
	public void update(Supplier supplier);
	
	public Supplier findId(int id);
}
