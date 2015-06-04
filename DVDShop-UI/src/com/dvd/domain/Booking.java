/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvd.domain;

import java.util.Date;


public class Booking {
    
    private int id;
    private int copyNumber;
    private int userID;
    private String bookingAddedDate;

    public Booking(int id, int copyNumber, int userID, String bookingAddedDate) {
        this.id = id;
        this.copyNumber = copyNumber;
        this.userID = userID;
        this.bookingAddedDate = bookingAddedDate;
    }

    public void setBookingAddedDate(String bookingAddedDate) {
        this.bookingAddedDate = bookingAddedDate;
    }

    
    
    public String getBookingAddedDate() {
        return bookingAddedDate;
    }

    public Booking() {
    }

    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the copyNumber
     */
    public int getCopyNumber() {
        return copyNumber;
    }

    /**
     * @param copyNumber the copyNumber to set
     */
    public void setCopyNumber(int copyNumber) {
        this.copyNumber = copyNumber;
    }

    /**
     * @return the userID
     */
    public int getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

  
  
    
    
    
    
}
