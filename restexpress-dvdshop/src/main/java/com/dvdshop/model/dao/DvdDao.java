package com.dvdshop.model.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class DvdDao {

	@Id
	@GenericGenerator(name = "kaugen", strategy = "increment")
	@GeneratedValue(generator = "kaugen")
	@Column(name = "dvdID")
	private int dvdID;

	public int getDvdID() {
		return dvdID;
	}

	public void setDvdID(int dvdID) {
		this.dvdID = dvdID;
	}

	private String title;
	private String actors;
	private int rating;
	private String definition;
	private String year;

	public DvdDao() {
		// TODO Auto-generated constructor stub
	}

	public DvdDao(String title, String actors, int rating, String definition,
			String year) {
		super();
		this.dvdID = 123;
		this.title = title;
		this.actors = actors;
		this.rating = rating;
		this.definition = definition;
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}
