package com.flofyhome.FLOFYHOME.facade;

import java.util.List;

import com.flofyhome.FLOFYHOME.model.Supplier;

public interface ISupplier {

	public List<Supplier> findAll();
	
	public Supplier create(Supplier supplier);
	
	public Supplier update(Supplier supplier);
	
	public Supplier findId(int id);
}
