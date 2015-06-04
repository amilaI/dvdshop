package com.dvdshop.model;

public class DVDCopy {
	
	private int copyNumber;
	private String isleNumber;   
    private String shelfNumber;
    private int dvdCode;
    private DVD dvd;
    private boolean isAvailable;
    
    public DVDCopy() {
		// TODO Auto-generated constructor stub
	}
    
    
    
	public DVDCopy(int copyNumber, String isleNumber, String shelfNumber,
			int dvdCode, DVD dvd, boolean isAvailable) {
		super();
		this.copyNumber = copyNumber;
		this.isleNumber = isleNumber;
		this.shelfNumber = shelfNumber;
		this.dvdCode = dvdCode;
		this.dvd = dvd;
		this.isAvailable = isAvailable;
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
	public DVD getDvd() {
		return dvd;
	}
	public void setDvd(DVD dvd) {
		this.dvd = dvd;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
    
  
    
    
}
