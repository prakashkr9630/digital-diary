package com.dineshonjava.service;

import java.util.List;

import com.dineshonjava.model.Relate;

public interface RelateService {
	
	public void relateArticle(Relate relate) throws Exception;
	public List<Relate> getRelatedArticle(int articleId);
	public void deleteRelateArticle(int articleId);
}
