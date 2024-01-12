package com.rentrabbit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentrabbit.model.Discount;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long> {
}
