package com.dvd.hibernate.domain;

import java.net.URLDecoder;

public class User {

	private String userName;
	private int userID;
	private String userType;
	

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String userName, int userID, String userType) {
		super();
		this.userName = decodeValues(userName);
		this.userID = userID;
		this.userType = userType;
		
	}

	public String decodeValues(String value) {
		return URLDecoder.decode(value);
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
