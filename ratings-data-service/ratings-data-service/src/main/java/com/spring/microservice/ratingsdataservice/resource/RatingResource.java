package com.spring.microservice.ratingsdataservice.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.microservice.ratingsdataservice.model.Rating;
import com.spring.microservice.ratingsdataservice.model.UserRating;

@RestController
@RequestMapping("ratingsdata")
public class RatingResource {

	@RequestMapping("{movieId}")
	public Rating getRating(@PathVariable String movieId) {
		return new Rating(movieId,4);
	}
	

	@RequestMapping("users/{userId}")
	public UserRating getRatings(@PathVariable String userId) {
		List<Rating> ratings = Arrays.asList(
				new Rating("1234",4),
				new Rating("2345",5));
		
	return new UserRating(ratings);
			}
}
