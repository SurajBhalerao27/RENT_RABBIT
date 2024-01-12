package com.rentrabbit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentrabbit.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
 
}
