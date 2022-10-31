package com.flofyhome.FLOFYHOME.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flofyhome.FLOFYHOME.facade.ISale;
import com.flofyhome.FLOFYHOME.model.Sale;
import com.flofyhome.FLOFYHOME.repository.SaleRepository;

@Service
public class SaleDao implements ISale {

	@Autowired
	private SaleRepository saleRepository;
	
	@Override
	public List<Sale> findAll(){
		return this.saleRepository.findAll();
	}
	
	@Override
	public void create (Sale sale) {
		this.saleRepository.save(sale);
	}
	
	@Override
	public void update (Sale sale) {
		this.saleRepository.save(sale);
	}
}
