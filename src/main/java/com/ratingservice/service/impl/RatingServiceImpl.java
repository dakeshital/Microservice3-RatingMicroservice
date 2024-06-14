package com.ratingservice.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratingservice.entity.Rating;
import com.ratingservice.exception.ResourceNotFoundException;
import com.ratingservice.repository.RatingRepository;
import com.ratingservice.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepository ratingRepository;
	
	@Override
	public Rating saveRating(Rating rating) {
		String ratingId=UUID.randomUUID().toString();
		rating.setRatingId(ratingId);
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getAllRatings() {
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getAllRatingsByUser(String userId) {
		return ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getAllRatingsByHotel(String hotelId) {
		return ratingRepository.findByHotelId(hotelId);
	}
	
	

//	@Override
//	public Rating getOneRating(String id) {
//		return ratingRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Rating not found...!! " +  id));
//	}
//
//	@Override
//	public Rating updateRatingById(Rating rating) {
//		return null;
//	}
//
	@Override
	public void deleteRating(String id) {
		ratingRepository.deleteById(id);
	}

}
