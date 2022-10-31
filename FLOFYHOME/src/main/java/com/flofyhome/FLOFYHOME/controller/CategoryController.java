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

import com.flofyhome.FLOFYHOME.implement.CategoryDao;
import com.flofyhome.FLOFYHOME.model.Category;

@Controller
@RequestMapping("/categorias")
public class CategoryController {
	
	private final Logger logg = LoggerFactory.getLogger(Category.class);
	
	@Autowired
	private CategoryDao categoryDao;
	
	@GetMapping("")
	public String indexCategory(Model model) {
		model.addAttribute("categorias", categoryDao.findAll());
		return "/category/indexcategory";
	}
	
	@GetMapping("/create")
	public String create() {
		return "/category/createcategory";
	}
	
	@PostMapping("/save")
	public String save(Category category) {
		logg.info("información de la categoria, {}", category);
		categoryDao.create(category);
		return "redirect:/categorias";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Category ca = categoryDao.findId(id);
		logg.info("Objecto llamado {}", ca);
		model.addAttribute("categoria", ca);
		return "/category/updatecategory";
	}
}
