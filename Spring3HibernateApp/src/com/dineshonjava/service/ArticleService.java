package com.dineshonjava.service;

import java.util.List;

import com.dineshonjava.model.Article;
import com.dineshonjava.model.QuestionSet;
import com.dineshonjava.model.rule;

/**
 * @author Praash 
 *
 */
public interface ArticleService {
	
	public void addArticle(Article article);

	public List<Article> listArticle();
	
	public Article getArticle(int id);
	
	public void deleteArticle(Article article);
	
	/**
	 * english api
	 */
	public void addrule(rule rule);
	public List<rule> getrule();
	public void saveExample(List<QuestionSet> questionset);
	public List<QuestionSet> getAllExample(String topic);
	
	
	
}
