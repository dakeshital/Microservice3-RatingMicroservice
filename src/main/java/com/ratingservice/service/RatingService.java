package com.ratingservice.service;

import java.util.List;

import com.ratingservice.entity.Rating;

public interface RatingService {

	Rating saveRating(Rating rating);

	List<Rating> getAllRatings();

//	Rating getOneRating(String id);
//
//	Rating updateRatingById(Rating rating);
//
	void deleteRating(String id);

	// get all rating by userId
	List<Rating> getAllRatingsByUser(String userId);

	// get all rating by hotel
	List<Rating> getAllRatingsByHotel(String hotelId);
	
}
