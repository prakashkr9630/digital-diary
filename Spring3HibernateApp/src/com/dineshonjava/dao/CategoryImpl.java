package com.dineshonjava.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dineshonjava.model.Category;

@Repository("categoryDao")
public class CategoryImpl implements CategoryDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addCategory(Category cat) {
		sessionFactory.getCurrentSession().saveOrUpdate(cat);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> listArticle() {

		return ((List<Category>) sessionFactory.getCurrentSession().createCriteria(Category.class).list());
	}
	
	

}
