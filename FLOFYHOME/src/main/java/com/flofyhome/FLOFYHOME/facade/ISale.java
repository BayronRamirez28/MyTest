package com.flofyhome.FLOFYHOME.facade;

import java.util.List;

import com.flofyhome.FLOFYHOME.model.Sale;

public interface ISale {

	public List<Sale> findAll();
	
	public void create(Sale sale);
	
	public void update(Sale sale);
}
