package com.rentrabbit.service;

import java.util.List;

import com.rentrabbit.model.Review;

public interface ReviewService {
	List<Review> getAllReviews();

	Review getReviewById(Long id);

	Review createReview(Review review);

	Review updateReview(Long id, Review updatedReview);

	void deleteReview(Long id);
}
