package com.dineshonjava.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dineshonjava.model.Article;
import com.dineshonjava.model.RelateUrl;


@Repository("RelateUrlDao")
public class RelateUrlDaoImpl implements RelateUrlDao{
	
	@Autowired
	 private SessionFactory sessionFactory;
	
	public void relateUrl(RelateUrl relateurl) throws Exception {
		int s_id =relateurl.getSourceID();		
		Object obj = sessionFactory.getCurrentSession().get(Article.class, relateurl.getSourceID());		
		if(obj!=null){			
			sessionFactory.getCurrentSession().saveOrUpdate(relateurl);
		}else{
			throw new Exception("Requested Article id "+s_id+" does not exist");
		}				
	}

	@Override
	public List<RelateUrl> getRelatedArticle(int articleId) {
		Query query = sessionFactory.getCurrentSession().createQuery("from RelateUrl where sourceID="+articleId);
		List<RelateUrl> list = query.list();		
		return list;
	}

	
	@Override
	public void deleteRelateArticle(int articleId) {		
		//sessionFactory.getCurrentSession().createQuery(arg0);
		System.out.println("Ready to delete this related article");
		
	}
	
		

}
