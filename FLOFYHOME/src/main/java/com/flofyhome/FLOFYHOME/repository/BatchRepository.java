package com.flofyhome.FLOFYHOME.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flofyhome.FLOFYHOME.model.Batch;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Integer> {

}
