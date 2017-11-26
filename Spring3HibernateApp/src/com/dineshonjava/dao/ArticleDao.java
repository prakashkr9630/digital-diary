package com.dineshonjava.dao;

import java.util.List;

import com.dineshonjava.model.Article;

/**
 * @author Prakash 
 *
 */
public interface ArticleDao {
	
	public void addArticle(Article article);

	public List<Article> listArticle();
	
	public Article getArticle(int id);
	
	public void deleteArticle(Article article);
}