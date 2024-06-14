package com.ratingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratingservice.entity.Rating;
import com.ratingservice.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingService ratingService;

	@PostMapping
	public ResponseEntity<Rating> createRatings(@RequestBody Rating rating) {
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.saveRating(rating));
	}

	@GetMapping
	public ResponseEntity<List<Rating>> getallRatings() {
		return ResponseEntity.ok(ratingService.getAllRatings());
	}

	// get all by user
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getallRatingsbyUser(@PathVariable String userId) {
		return ResponseEntity.ok(ratingService.getAllRatingsByUser(userId));
	}

	// get all by hotel
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getallRatingsbyHotel(@PathVariable String hotelId) {
		return ResponseEntity.ok(ratingService.getAllRatingsByHotel(hotelId));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteRatingById(@PathVariable String id) {
		ratingService.deleteRating(id);
		return ResponseEntity.ok("Rating successfully deleted !!");
	}	

}
