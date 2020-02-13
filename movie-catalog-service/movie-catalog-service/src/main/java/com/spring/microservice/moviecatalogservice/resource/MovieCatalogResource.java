package com.spring.microservice.moviecatalogservice.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.spring.microservice.moviecatalogservice.model.Movie;
import com.spring.microservice.moviecatalogservice.model.Rating;
import com.spring.microservice.moviecatalogservice.model.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	private RestTemplate restTemplate; // bean is automatically injected here by spring

	@RequestMapping("/{userid}")
	public List<CatalogItem> getCatalog(@PathVariable String userid){
		
	    // below method is used to call another microservice using eureka and service discovery. so that we do not hardcode URL (IP address /host name)
		UserRating userRating = restTemplate.getForObject("http://rating-data-service/ratingsdata/users/"+userid, UserRating.class);
		
		return userRating.getRatingsList().stream().map(rating -> {
			Movie movie= restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(), Movie.class);
			return new CatalogItem(movie.getName(), "test", rating.getRating()); 
		})
		.collect(Collectors.toList());
		
	
	}
}
