/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvd.domain;


public class DvdCopy {
    
    private String isleNumber;
    private String copyNumber;
    private String shelfNumber;
    private Dvd dvd;
    private boolean isAvailable;

    public DvdCopy() {
    }

    public DvdCopy(String isleNumber, String copyNumber, String shelfNumber, Dvd dvd, String isAvailable) {
        this.isleNumber = isleNumber;
        this.copyNumber = copyNumber;
        this.shelfNumber = shelfNumber;
        this.dvd = dvd;
        System.out.println(isAvailable);
        if(isAvailable.equals("1")){
             this.isAvailable = true;
        }else{
         this.isAvailable = false;
        }
       
    }

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    
    
    
    /**
     * @return the isleNumber
     */
    public String getIsleNumber() {
        return isleNumber;
    }

    /**
     * @param isleNumber the isleNumber to set
     */
    public void setIsleNumber(String isleNumber) {
        this.isleNumber = isleNumber;
    }

    /**
     * @return the copyNumber
     */
    public String getCopyNumber() {
        return copyNumber;
    }

    /**
     * @param copyNumber the copyNumber to set
     */
    public void setCopyNumber(String copyNumber) {
        this.copyNumber = copyNumber;
    }

    /**
     * @return the shelfNumber
     */
    public String getShelfNumber() {
        return shelfNumber;
    }

    /**
     * @param shelfNumber the shelfNumber to set
     */
    public void setShelfNumber(String shelfNumber) {
        this.shelfNumber = shelfNumber;
    }

    /**
     * @return the dvd
     */
    public Dvd getDvd() {
        return dvd;
    }

    /**
     * @param dvd the dvd to set
     */
    public void setDvd(Dvd dvd) {
        this.dvd = dvd;
    }
    
    
}
