package com.dineshonjava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dineshonjava.dao.CategoryDao;
import com.dineshonjava.model.Category;

@Service("categoryService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao catao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addCategory(Category cat) {
		catao.addCategory(cat);		
	}

	@Override
	public List<Category> listArticle() {
		return catao.listArticle();
	}

}
