package com.rentrabbit.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentrabbit.model.Review;
import com.rentrabbit.repository.ReviewRepository;
import com.rentrabbit.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private final ReviewRepository reviewRepository;

	public ReviewServiceImpl(ReviewRepository reviewRepository) {
		this.reviewRepository = reviewRepository;
	}

	public List<Review> getAllReviews() {
		return reviewRepository.findAll();
	}

	public Review getReviewById(Long id) {
		Optional<Review> optionalReview = reviewRepository.findById(id);
		return optionalReview.orElse(null);
	}

	public Review createReview(Review review) {
		return reviewRepository.save(review);
	}

	public Review updateReview(Long id, Review updatedReview) {
		Optional<Review> optionalReview = reviewRepository.findById(id);
		if (optionalReview.isPresent()) {
			Review existingReview = optionalReview.get();
			// Update fields based on your requirements
			existingReview.setRating(updatedReview.getRating());
			existingReview.setComment(updatedReview.getComment());
			// Update other fields as needed
			return reviewRepository.save(existingReview);
		}
		return null; // Review with the given id not found
	}

	public void deleteReview(Long id) {
		reviewRepository.deleteById(id);
	}
}
