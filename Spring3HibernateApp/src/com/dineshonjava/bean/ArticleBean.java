package com.dineshonjava.bean;

import java.util.Date;

public class ArticleBean {

	
	private Integer id;
	private String title;
	private String articletext;
	private Date date;
	private String catname;
	
	
	
	
	public String getCatname() {
		return catname;
	}
	public void setCatname(String catname) {
		this.catname = catname;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArticletext() {
		return articletext;
	}
	public void setArticletext(String articletext) {
		this.articletext = articletext;
	}
}
