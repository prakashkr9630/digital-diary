package com.dineshonjava.service;

import java.util.List;

import com.dineshonjava.dao.SearchDao;
import com.dineshonjava.model.Search;

/**
 * @author Prakash
 *
 */

/*@Service("searchService")*/
/*@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)*/
public class SearchServiceImpl implements SearchService{

	private SearchDao searchdao;
	
	@Override
	public List<Search> listArticle(String searchtext, String mode) {
		
		return searchdao.listArticle("searchtext", "mode");
	}
	
	
	
	
}
