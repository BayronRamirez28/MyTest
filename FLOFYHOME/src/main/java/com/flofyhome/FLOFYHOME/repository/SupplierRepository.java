package com.flofyhome.FLOFYHOME.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flofyhome.FLOFYHOME.model.Supplier;

@Repository
public interface SupplierRepository  extends JpaRepository<Supplier, Integer>{

}
