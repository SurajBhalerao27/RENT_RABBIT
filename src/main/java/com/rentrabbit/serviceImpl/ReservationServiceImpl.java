package com.rentrabbit.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentrabbit.model.Reservation;
import com.rentrabbit.repository.ReservationRepository;
import com.rentrabbit.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	private final ReservationRepository reservationRepository;

	public ReservationServiceImpl(ReservationRepository reservationRepository) {
		this.reservationRepository = reservationRepository;
	}

	public List<Reservation> getAllReservations() {
		return reservationRepository.findAll();
	}

	public Reservation getReservationById(Long id) {
		Optional<Reservation> optionalReservation = reservationRepository.findById(id);
		return optionalReservation.orElse(null);
	}

	public Reservation createReservation(Reservation reservation) {
		return reservationRepository.save(reservation);
	}

	public Reservation updateReservation(Long id, Reservation updatedReservation) {
		Optional<Reservation> optionalReservation = reservationRepository.findById(id);
		if (optionalReservation.isPresent()) {
			Reservation existingReservation = optionalReservation.get();
			// Update fields based on your requirements
//            existingReservation.setReservationDate(updatedReservation.getReservationDate());
//            existingReservation.setCustomerName(updatedReservation.getCustomerName());
			// Update other fields as needed
			return reservationRepository.save(existingReservation);
		}
		return null; // Reservation with the given id not found
	}

	public void deleteReservation(Long id) {
		reservationRepository.deleteById(id);
	}
}
