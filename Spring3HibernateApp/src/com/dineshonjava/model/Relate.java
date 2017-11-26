package com.dineshonjava.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Relate")
public class Relate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer Id;
	
	
	@Column(name = "sourceID")
	private Integer sourceID;
	
	@Column(name = "desinationId")
	private Integer desinationId;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Integer getSourceID() {
		return sourceID;
	}

	public void setSourceID(Integer sourceID) {
		this.sourceID = sourceID;
	}

	public Integer getDesinationId() {
		return desinationId;
	}

	public void setDesinationId(Integer desinationId) {
		this.desinationId = desinationId;
	}
}
