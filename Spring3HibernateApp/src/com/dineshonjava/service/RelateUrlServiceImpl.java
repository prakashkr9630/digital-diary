package com.dineshonjava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dineshonjava.dao.RelateUrlDao;
import com.dineshonjava.model.RelateUrl;

@Service("relateUrlService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class RelateUrlServiceImpl implements RelateUrlService{
	
	@Autowired
	private RelateUrlDao relateUrlDao;

	@Override
	public void relateUrl(RelateUrl relateurl)  throws Exception{
		relateUrlDao.relateUrl(relateurl);
	}

	@Override
	public List<RelateUrl> getRelatedArticle(int articleId) {

		return relateUrlDao.getRelatedArticle(articleId);
	}

	@Override
	public void deleteRelateArticle(int articleId) {
		relateUrlDao.deleteRelateArticle(articleId);		
	}

}
