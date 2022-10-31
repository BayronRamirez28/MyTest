package com.flofyhome.FLOFYHOME.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flofyhome.FLOFYHOME.implement.SaleDao;
import com.flofyhome.FLOFYHOME.model.Sale;

@Controller
@RequestMapping (path = "/api/FLOFYHOME/Sale")
public class SaleController {
	
	@Autowired
	private SaleDao saleDao;
	
	@GetMapping ("/all")
	public ResponseEntity<Map<String,Object>> allSale(){
		List<Sale> listSales=this.saleDao.findAll();
		Map<String,Object> respon = new HashMap<String,Object>();
		respon.put("date", listSales);
		return new ResponseEntity<>(respon,HttpStatus.OK);
	}
	
	@PostMapping
	public void create(@RequestBody Sale sale) {
		saleDao.create(sale);
	}
	
	@PutMapping
	public void update(@RequestBody Sale sale) {
		saleDao.update(sale);
	}

}
