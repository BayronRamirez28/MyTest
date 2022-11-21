package com.flofyhome.FLOFYHOME.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flofyhome.FLOFYHOME.facade.ICategory;
import com.flofyhome.FLOFYHOME.model.Category;
import com.flofyhome.FLOFYHOME.repository.CategoryRepository;

@Service
public class CategoryDao implements ICategory{

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category>findAll(){
		return new ArrayList<>(categoryRepository.findAll());
	}

	@Override
	public Category create(Category category) {
		return this.categoryRepository.save(category);
		
	}

	@Override
	public Category update(Category category) {
		return this.categoryRepository.save(category);
		
	}

	@Override
	public Category findId(int id) {
		return this.categoryRepository.findById(id).get();
	}
}
