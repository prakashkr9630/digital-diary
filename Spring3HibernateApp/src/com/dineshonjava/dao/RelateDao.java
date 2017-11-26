package com.dineshonjava.dao;

import java.util.List;

import com.dineshonjava.model.Relate;

public interface RelateDao {
	
	public void relateArticle(Relate relate) throws Exception;
	public List<Relate> getRelatedArticle(int articleId);	
	public void deleteRelateArticle(int articleId);

}
