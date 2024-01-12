package com.rentrabbit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentrabbit.model.Review;
import com.rentrabbit.serviceImpl.ReviewServiceImpl;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
	@Autowired
	ReviewServiceImpl reviewService;

	@GetMapping
	public ResponseEntity<List<Review>> getAllReviews() {
		List<Review> reviews = reviewService.getAllReviews();
		return new ResponseEntity<>(reviews, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
		Review review = reviewService.getReviewById(id);
		if (review != null) {
			return new ResponseEntity<>(review, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<Review> createReview(@RequestBody Review review) {
		Review createdReview = reviewService.createReview(review);
		return new ResponseEntity<>(createdReview, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Review> updateReview(@PathVariable Long id, @RequestBody Review updatedReview) {
		Review updated = reviewService.updateReview(id, updatedReview);
		if (updated != null) {
			return new ResponseEntity<>(updated, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
		reviewService.deleteReview(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
