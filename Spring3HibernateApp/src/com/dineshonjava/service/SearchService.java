package com.dineshonjava.service;

import java.util.List;

import com.dineshonjava.model.Search;

/**
 * @author Praash 
 *
 */
public interface SearchService {
	
	
	public List<Search> listArticle(String searchtext, String mode);
	
}
