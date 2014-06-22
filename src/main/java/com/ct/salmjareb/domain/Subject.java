package com.ct.salmjareb.domain;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.ct.salmjareb.enumeration.SubjectStatus;
import com.ct.salmjareb.enumeration.SubjectType;

@Entity
@Table(name = "SUBJECT")
public class Subject implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SUBJECT_ID")
	private Long subjectId;
	
	@NotNull
    @Size(max = 100)
	@Column(name = "SUBJECT_TITLE")
    private String subjectTitle;

	@NotNull
	@Column(name = "SUBJECT_DESCRIPTION", columnDefinition = "LONGTEXT")
	private String subjectDescription;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "SUBJECT_CREATED_DATE")
	private Date subjectCreatedDate;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUBJECT_OWNER", referencedColumnName ="USER_ID")
	private User subjectOwner;
	
	@NotNull
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "SUBJECT_STATUS")
	private SubjectStatus subjectStatus;
	
	@NotNull
	@Enumerated(EnumType.ORDINAL)
	@Column(name= "SUBJECT_TYPE")
	private SubjectType subjectType;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "SUBJECT_TAGS",
		joinColumns = {
			@JoinColumn(name = "SUBJECT_ID", referencedColumnName = "SUBJECT_ID")
		}, 
		inverseJoinColumns = {
			@JoinColumn(name = "TAG_ID", referencedColumnName = "TAG_ID")
		})
	private Set<Tag> tags;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "CATEGORY_ID", referencedColumnName = "CATEGORY_ID")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="PARENT_ID", referencedColumnName = "SUBJECT_ID")
	private Subject subject;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="subject")
	private Set<Subject> subjects;

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectTitle() {
		return subjectTitle;
	}

	public void setSubjectTitle(String subjectTitle) {
		this.subjectTitle = subjectTitle;
	}

	public String getSubjectDescription() {
		return subjectDescription;
	}

	public void setSubjectDescription(String subjectDescription) {
		this.subjectDescription = subjectDescription;
	}

	public Date getSubjectCreatedDate() {
		return subjectCreatedDate;
	}

	public void setSubjectCreatedDate(Date subjectCreatedDate) {
		this.subjectCreatedDate = subjectCreatedDate;
	}

	public User getSubjectOwner() {
		return subjectOwner;
	}

	public void setSubjectOwner(User subjectOwner) {
		this.subjectOwner = subjectOwner;
	}

	public SubjectStatus getSubjectStatus() {
		return subjectStatus;
	}

	public void setSubjectStatus(SubjectStatus subjectStatus) {
		this.subjectStatus = subjectStatus;
	}

	public SubjectType getSubjectType() {
		return subjectType;
	}

	public void setSubjectType(SubjectType subjectType) {
		this.subjectType = subjectType;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	
}
