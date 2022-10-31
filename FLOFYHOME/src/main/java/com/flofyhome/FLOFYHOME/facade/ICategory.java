package com.flofyhome.FLOFYHOME.facade;

import java.util.List;

import com.flofyhome.FLOFYHOME.model.Category;

public interface ICategory {

	public List<Category> findAll();
	
	public void create (Category category);
	
	public void update (Category category);
	
	public Category findId(int id);
}
