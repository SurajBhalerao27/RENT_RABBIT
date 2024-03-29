package com.rentrabbit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentrabbit.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
