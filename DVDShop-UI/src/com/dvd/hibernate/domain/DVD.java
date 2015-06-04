package com.dvd.hibernate.domain;

public class DVD {

	private int code;
	private String title;
	private String actors;
	private int rating;
	private String definiiton;
	private String year;

	public DVD() {
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
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

	public String getDefiniiton() {
		return definiiton;
	}

	public void setDefiniiton(String definiiton) {
		this.definiiton = definiiton;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public DVD(int code, String title, String actors, int rating,
			String definiiton, String year) {
		super();
		this.code = code;
		this.title = title;
		this.actors = actors;
		this.rating = rating;
		this.definiiton = definiiton;
		this.year = year;
	}

}
