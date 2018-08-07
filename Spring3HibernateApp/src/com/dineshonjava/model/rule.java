package com.dineshonjava.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "rule")
public class rule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "topic")
	private String topic;
	
	@Lob
	@Column(name = "ruletext")
	private String ruletext;
	
	
	@Column(name = "title")
	private String title;	


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getRuletext() {
		return ruletext;
	}

	public void setRuletext(String ruletext) {
		this.ruletext = ruletext;
	}
}
