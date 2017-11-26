package com.dineshonjava.dao;

import java.util.List;

import com.dineshonjava.model.Category;

public interface CategoryDao {
	
	public void addCategory(Category cat);
	
	public List<Category> listArticle();	
}
