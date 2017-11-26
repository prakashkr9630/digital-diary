package com.dineshonjava.dao;

import java.util.List;

import com.dineshonjava.model.Search;

/**
 * @author Prakash 
 *
 */
public interface SearchDao {
	
	public List<Search> listArticle(String searchtext, String mode);
	
	
}
