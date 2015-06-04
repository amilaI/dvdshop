package com.dvd.hibernate.doa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class BookingDao {

	@Id
	@GenericGenerator(name = "kaugen", strategy = "increment")
	@GeneratedValue(generator = "kaugen")
	@Column(name = "id")
	private int id;

	private int copyNumber;
	private int userID;
	private Date bookingAddedDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCopyNumber() {
		return copyNumber;
	}

	public void setCopyNumber(int copyNumber) {
		this.copyNumber = copyNumber;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public Date getBookingAddedDate() {
		return bookingAddedDate;
	}

	public void setBookingAddedDate(Date bookingAddedDate) {
		this.bookingAddedDate = bookingAddedDate;
	}

	public BookingDao(int copyNumber, int userID) {
		super();
		this.id = 111;
		this.copyNumber = copyNumber;
		this.userID = userID;
		this.bookingAddedDate = new Date();
	}

	public BookingDao() {
	}

}
