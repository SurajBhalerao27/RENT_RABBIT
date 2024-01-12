package com.rentrabbit.service;

import java.util.List;

import com.rentrabbit.model.Reservation;

public interface ReservationService {
	List<Reservation> getAllReservations();

	Reservation getReservationById(Long id);

	Reservation createReservation(Reservation reservation);

	Reservation updateReservation(Long id, Reservation updatedReservation);

	void deleteReservation(Long id);
}
