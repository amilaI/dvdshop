package com.dvd.domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Dvd {
    
    private int code;
    private String title;
    private String actors;
    private int rating;
    private String definiiton;
    private String year;

    public Dvd(int code, String title, String actors, int rating, String definiiton, String year) {
        this.code = code;
        this.title = title;
        this.actors = actors;
        this.rating = rating;
        this.definiiton = definiiton;
        this.year = year;
    }

    public Dvd() {
    }
    

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    

    
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the actors
     */
    public String getActors() {
        return actors;
    }

    /**
     * @param actors the actors to set
     */
    public void setActors(String actors) {
        this.actors = actors;
    }

    /**
     * @return the rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * @return the definiiton
     */
    public String getDefiniiton() {
        return definiiton;
    }

    /**
     * @param definiiton the definiiton to set
     */
    public void setDefiniiton(String definiiton) {
        this.definiiton = definiiton;
    }

    /**
     * @return the year
     */
    public String getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        this.year = year;
    }
    
}
