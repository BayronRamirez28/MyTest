package com.flofyhome.FLOFYHOME.facade;

import java.util.List;

import com.flofyhome.FLOFYHOME.model.Category;

public interface ICategory {

	public List<Category> findAll();
	
	public Category create (Category category);
	
	public Category update (Category category);
	
	public Category findId(int id);
}
