package com.flofyhome.FLOFYHOME.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flofyhome.FLOFYHOME.facade.ISupplier;
import com.flofyhome.FLOFYHOME.model.Supplier;
import com.flofyhome.FLOFYHOME.repository.SupplierRepository;

@Service
public class SupplierDao implements ISupplier{

	@Autowired
	private SupplierRepository supplierRepository;

	@Override
	public List<Supplier> findAll() {
		return this.supplierRepository.findAll();
	}

	@Override
	public void create(Supplier supplier) {
		this.supplierRepository.save(supplier);
		
	}

	@Override
	public void update(Supplier supplier) {
		this.supplierRepository.save(supplier);
		
	}

	@Override
	public Supplier findId(int id) {
		return this.supplierRepository.getOne(id);
	}
}
