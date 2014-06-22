package com.ct.salmjareb.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TAG")
public class Tag implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TAG_ID")
	private Long tagId;
	
	@Column(name = "TAG_NAME")
	private String tagName;
	
	@Column(name = "TAG_PERMALINK")
	private String tagPermalink;

	public Long getTagId() {
		return tagId;
	}

	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getTagPermalink() {
		return tagPermalink;
	}

	public void setTagPermalink(String tagPermalink) {
		this.tagPermalink = tagPermalink;
	}
	

}
