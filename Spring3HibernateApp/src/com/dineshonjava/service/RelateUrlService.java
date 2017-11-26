package com.dineshonjava.service;

import java.util.List;

import com.dineshonjava.model.RelateUrl;

public interface RelateUrlService {
	
	public void relateUrl(RelateUrl relateurl)  throws Exception;
	public List<RelateUrl> getRelatedArticle(int articleId);
	public void deleteRelateArticle(int articleId);	
}
