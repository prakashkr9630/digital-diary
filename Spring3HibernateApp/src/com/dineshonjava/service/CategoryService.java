package com.dineshonjava.service;

import java.util.List;

import com.dineshonjava.model.Category;

public interface CategoryService {

	public void addCategory(Category cat);

	public List<Category> listArticle();

}
