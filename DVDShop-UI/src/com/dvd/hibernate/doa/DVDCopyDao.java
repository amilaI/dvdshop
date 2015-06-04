package com.dvd.hibernate.doa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class DVDCopyDao {

	@Id
	@GenericGenerator(name = "kaugen", strategy = "increment")
	@GeneratedValue(generator = "kaugen")
	@Column(name = "copyNumber")
	private int copyNumber;

	private String isleNumber;
	private String shelfNumber;
	private int dvdCode;
	private String isAvailable;

	public DVDCopyDao() {
		// TODO Auto-generated constructor stub
	}

	public int getCopyNumber() {
		return copyNumber;
	}

	public void setCopyNumber(int copyNumber) {
		this.copyNumber = copyNumber;
	}

	public String getIsleNumber() {
		return isleNumber;
	}

	public void setIsleNumber(String isleNumber) {
		this.isleNumber = isleNumber;
	}

	public String getShelfNumber() {
		return shelfNumber;
	}

	public void setShelfNumber(String shelfNumber) {
		this.shelfNumber = shelfNumber;
	}

	public int getDvdCode() {
		return dvdCode;
	}

	public void setDvdCode(int dvdCode) {
		this.dvdCode = dvdCode;
	}

	public String isAvailable() {
		return isAvailable;
	}

	public void setAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}

	public DVDCopyDao(int copyNumber, String isleNumber, String shelfNumber,
			int dvdCode, String isAvailable) {
		super();
		this.copyNumber = 123;
		this.isleNumber = isleNumber;
		this.shelfNumber = shelfNumber;
		this.dvdCode = dvdCode;
		this.isAvailable = isAvailable;
	}

}
