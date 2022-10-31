package com.flofyhome.FLOFYHOME.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flofyhome.FLOFYHOME.implement.SupplierDao;
import com.flofyhome.FLOFYHOME.model.Supplier;

@Controller
@RequestMapping("/proveedores")
public class SupplierController {
	
	private final Logger logg= LoggerFactory.getLogger(Supplier.class);
	
	@Autowired
	private SupplierDao supplierDao;

	@GetMapping("")
	public String indexsupplier(Model model) {
		model.addAttribute("proveedores", supplierDao.findAll());
		return "/supplier/indexsupplier";
		
	}
	
	@GetMapping("/create")
	public String create() {
	return "/supplier/createsupplier";	
	}
	
	@PostMapping("/save")
	public String save(Supplier supplier) {
		logg.info("Información del proveedor, {}",supplier);
		supplierDao.create(supplier);
		return "redirect:/proveedores";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Supplier su = supplierDao.findId(id);
		logg.info("Objeto llamado {}", su);
		model.addAttribute("proveedor", su);
		return "/supplier/updatesupplier";
	}
	
}
