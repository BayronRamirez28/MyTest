package com.flofyhome.FLOFYHOME.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flofyhome.FLOFYHOME.implement.BatchDao;
import com.flofyhome.FLOFYHOME.implement.ProductDao;
import com.flofyhome.FLOFYHOME.model.Batch;
import com.flofyhome.FLOFYHOME.model.Product;

@Controller
@RequestMapping("/lotes")
public class BatchController {
	
	private final Logger logg= LoggerFactory.getLogger(Batch.class);

	@Autowired
	private BatchDao batchDao;
	
	@Autowired ProductDao productDao;
	
	
}
