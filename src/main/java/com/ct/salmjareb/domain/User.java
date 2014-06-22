package com.ct.salmjareb.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.ct.salmjareb.enumeration.UserAccountStatus;


@Entity
@Table(name = "USER")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private Long userId;
	
	/************** connection info ****************/
	
	@Column(name = "USER_NAME")
	private String userName;
	
	@NotNull
    @Size(min = 6, max = 16)
	@Column(name = "USER_PASSWORD")
	private String userPassword;
	
	@NotNull
	@Pattern(regexp = "")
	@Column(name = "USER_EMAIL")
	private String userEmail;
	
	@NotNull
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "USER_ACCOUNT_STATUS")
	private UserAccountStatus userAccountStaus;
	
	/************* connection history **************/
	@NotNull
	@Column(name = "USER_CREATED_DATE")
	@Temporal(TemporalType.DATE)
	private Date userCreatedDate;
	
	@Column(name = "USER_LAST_CNNECTION_DATE")
	@Temporal(TemporalType.TIME)
	private Date userLastConnectionDate;
	
	@Column(name = "USER_LAST_CONNECTION_IP_ADDRESS")
	private String userLastConnectionIpAddress;
	
	/****************** personal info***************/
	
	@Column(name = "USER_FIRST_NAME")
	private String userFirstName;
	
	@Column(name = "USER_LAST_NAME")
	private String userLastName;
	
	@Column(name = "USER_CITY")
	private String userCity;
	
	@Column(name = "USER_PHONE_NUMBER")
	@Pattern(regexp = "")
	private String userPhoneNumber;
	
	/**********************************************/
	
	@OneToMany(mappedBy ="subjectOwner", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private Set<Subject> userSubjects;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public UserAccountStatus getUserAccountStaus() {
		return userAccountStaus;
	}

	public void setUserAccountStaus(UserAccountStatus userAccountStaus) {
		this.userAccountStaus = userAccountStaus;
	}

	public Date getUserCreatedDate() {
		return userCreatedDate;
	}

	public void setUserCreatedDate(Date userCreatedDate) {
		this.userCreatedDate = userCreatedDate;
	}

	public Date getUserLastConnectionDate() {
		return userLastConnectionDate;
	}

	public void setUserLastConnectionDate(Date userLastConnectionDate) {
		this.userLastConnectionDate = userLastConnectionDate;
	}

	public String getUserLastConnectionIpAddress() {
		return userLastConnectionIpAddress;
	}

	public void setUserLastConnectionIpAddress(String userLastConnectionIpAddress) {
		this.userLastConnectionIpAddress = userLastConnectionIpAddress;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserCity() {
		return userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}

	public Set<Subject> getUserSubjects() {
		return userSubjects;
	}

	public void setUserSubjects(Set<Subject> userSubjects) {
		this.userSubjects = userSubjects;
	}
	
}
