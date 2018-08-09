package com.dineshonjava.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dineshonjava.model.Article;
import com.dineshonjava.model.QuestionSet;
import com.dineshonjava.model.rule;

/**
 * @author Prakash
 *
 */
@Repository("articleDao")
public class ArticleDaoImpl implements ArticleDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addArticle(Article article) {
		sessionFactory.getCurrentSession().saveOrUpdate(article);
	}

	@SuppressWarnings("unchecked")
	public List<Article> listArticle() {
		return (List<Article>) sessionFactory.getCurrentSession().createCriteria(Article.class).list();
	}

	public Article getArticle(int id) {
		return (Article) sessionFactory.getCurrentSession().get(Article.class, id);
	}

	public void deleteArticle(Article article) {		
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Article WHERE id = "+article.getId()).executeUpdate();
	}

	@Override
	public void addrule(rule rule) {
		 sessionFactory.getCurrentSession().save(rule);
		
	}

	@Override
	public List<rule> getrule() {
		//return (rule) sessionFactory.getCurrentSession().get(rule.class, 1);
		return  (List<rule>) sessionFactory.getCurrentSession().createCriteria(rule.class).list();
	}

	@Override
	public void saveExample(List<QuestionSet> questionsets) {
		for(QuestionSet questionset:  questionsets){
			sessionFactory.getCurrentSession().save(questionset);
		}		
	}

	@Override
	public List<QuestionSet> getAllExample(String topic) {
		
		if(topic!=null && topic.length()> 0){
			String SQL_QUERY = "from QuestionSet WHERE title='" + topic + "'";			
			Query query = sessionFactory.getCurrentSession().createQuery(SQL_QUERY);
			return query.list();	
		}else{
			return (List<QuestionSet>) sessionFactory.getCurrentSession().createCriteria(QuestionSet.class).list();
		}
	}

}
