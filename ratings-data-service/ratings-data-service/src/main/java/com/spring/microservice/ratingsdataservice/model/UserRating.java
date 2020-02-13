package com.spring.microservice.ratingsdataservice.model;

import java.util.List;

public class UserRating {
	
	private List<Rating> ratingsList;

	public List<Rating> getRatingsList() {
		return ratingsList;
	}

	public void setRatingsList(List<Rating> ratingsList) {
		this.ratingsList = ratingsList;
	}

	public UserRating(List<Rating> ratingsList) {
		super();
		this.ratingsList = ratingsList;
	}
	
	

}
