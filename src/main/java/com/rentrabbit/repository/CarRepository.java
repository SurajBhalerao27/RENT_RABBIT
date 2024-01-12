package com.rentrabbit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentrabbit.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
	
}
