package com.dvdshop.model.dao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class UserDao {

	@Id
	private int userID;

	private String userName;

	private String userType;

	public UserDao() {
		// TODO Auto-generated constructor stub
	}

	public UserDao(String userName, int userID, String userType) {
		super();
		this.userName = userName;
		this.userID = userID;
		this.userType = userType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}
