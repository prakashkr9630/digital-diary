package com.dineshonjava.dao;

import java.util.ArrayList;
import java.util.List;

import com.dineshonjava.model.Search;

/**
 * @author Prakash 
 *
 */
/*@Repository("searchDao")*/
public class SearchDaoImpl implements SearchDao{
	
	/*@Autowired*/
	/*private SessionFactory sessionFactory;*/

	@Override
	public List<Search> listArticle(String searchtext, String mode) {
		//sessionFactory.getCurrentSession();
		
		System.out.println("search string:"+searchtext);
		System.out.println("Mode:"+mode);
		
		List<Search> ls = new ArrayList<Search>();
		Search ss;
		
		for(int i=0;i<10;i++){
			ss =  new Search();
			ss.setSearchString("New value_"+i);
			ls.add(ss);
		}
		return ls;
	}
	
	
	
}
