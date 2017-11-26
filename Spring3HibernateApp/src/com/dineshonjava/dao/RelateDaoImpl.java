package com.dineshonjava.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dineshonjava.model.Relate;

@Repository("RelateDao")
public class RelateDaoImpl implements RelateDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void relateArticle(Relate relate) throws Exception {
		
		Object obj = sessionFactory.getCurrentSession().get(Relate.class,relate.getSourceID());
		Object obj1 = sessionFactory.getCurrentSession().get(Relate.class,relate.getDesinationId());		
		if(obj!=null && obj1!=null){
			sessionFactory.getCurrentSession().saveOrUpdate(relate);
		}else{
			throw new Exception("Either Source or Desitnation ID does not exist");
		}
		
	}

	@Override
	public List<Relate> getRelatedArticle(int articleId) {		
		Query query = sessionFactory.getCurrentSession().createQuery("from Relate where sourceID="+articleId);
		List<Relate> list = query.list();
		return list;
		
	}

	@Override
	public void deleteRelateArticle(int articleId) {
		System.out.println("ready to delete article");
		sessionFactory.getCurrentSession().createQuery("delete from Relate where sourceID="+articleId+" or destinationId="+articleId);
	}
}
