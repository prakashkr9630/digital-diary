package com.dineshonjava.util;

import java.util.ArrayList;
import java.util.List;

import com.dineshonjava.bean.ArticleBean;
import com.dineshonjava.model.Relate;

public class Operation {
	
	public static List<ArticleBean>  getRelatedArticle(List<Relate> relatedArticleList, List<ArticleBean> articles){
		List<ArticleBean> list = new ArrayList<ArticleBean>();
		int relatedArticle=0;
		for(Relate relate : relatedArticleList){
			relatedArticle = relate.getDesinationId();
			for(ArticleBean bean: articles){
				if(bean.getId()==relatedArticle){
					list.add(bean);
				}
			}
		}
		
		return list;		
	}
		
}
