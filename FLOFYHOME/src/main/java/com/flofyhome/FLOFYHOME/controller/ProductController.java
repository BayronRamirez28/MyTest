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

import com.flofyhome.FLOFYHOME.implement.CategoryDao;
import com.flofyhome.FLOFYHOME.implement.ProductDao;
import com.flofyhome.FLOFYHOME.implement.SupplierDao;
import com.flofyhome.FLOFYHOME.model.Category;
import com.flofyhome.FLOFYHOME.model.Product;
import com.flofyhome.FLOFYHOME.model.Supplier;




@Controller
@RequestMapping("productos")
public class ProductController {

	private final Logger logg = LoggerFactory.getLogger(Product.class);
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private SupplierDao supplierDao;
	
	@Autowired
	private CategoryDao categoryDao;

	@GetMapping("")
	public String indexproduct(Model model, @Param("keyWord") String keyWord) {
		List<Supplier> Proveedor = supplierDao.findAll();
		List<Category> Categoria = categoryDao.findAll();
		model.addAttribute("keyWord", keyWord);
		model.addAttribute("productos", productDao.findAll(keyWord));
		model.addAttribute("Proveedores", Proveedor);
		model.addAttribute("Categorias", Categoria);
		return "/product/indexproduct";
	}

	@GetMapping("/create")
	public String create(Model model) {
		List<Supplier> listaproveedores = supplierDao.findAll();
		List<Category> listacategorias = categoryDao.findAll();
		model.addAttribute("producto", new Product());
		model.addAttribute("listaproveedores", listaproveedores );
		model.addAttribute("listacategorias", listacategorias);
		
		return "/product/createproduct";
	}

	@PostMapping("/save")
	public String save(Product product) {
		logg.info("Información del producto, {}", product);
		productDao.create(product);
		return "redirect:/productos";
	}
	
	@GetMapping("/edit/{id}")
	public String edit (@PathVariable Integer id, Model model) {
		Product pr = productDao.findId(id);
		logg.info("Objeto llamado {}", pr);
		List<Supplier> listaproveedores = supplierDao.findAll();
		List<Category> listacategorias = categoryDao.findAll();
		model.addAttribute("producto", pr);
		model.addAttribute("listaproveedores", listaproveedores );
		model.addAttribute("listacategorias", listacategorias);
		return "/product/updateproduct";
		
	}
	

}
