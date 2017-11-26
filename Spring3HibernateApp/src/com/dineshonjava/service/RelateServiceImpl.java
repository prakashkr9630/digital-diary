package com.dineshonjava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dineshonjava.dao.RelateDao;
import com.dineshonjava.model.Relate;

@Service("relateService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class RelateServiceImpl implements RelateService{
	
	@Autowired
	private RelateDao relateDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void relateArticle(Relate relate) throws Exception{		
		relateDao.relateArticle(relate);		
	}

	@Override
	public List<Relate> getRelatedArticle(int articleId) {		
		return relateDao.getRelatedArticle(articleId);
	}

	@Override
	public void deleteRelateArticle(int articleId) {
		relateDao.deleteRelateArticle(articleId);
	}

}
