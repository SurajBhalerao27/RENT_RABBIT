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

import com.rentrabbit.model.Reservation;
import com.rentrabbit.serviceImpl.ReservationServiceImpl;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

	@Autowired
	ReservationServiceImpl reservationService;

	@GetMapping
	public ResponseEntity<List<Reservation>> getAllReservations() {
		List<Reservation> reservations = reservationService.getAllReservations();
		return new ResponseEntity<>(reservations, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {
		Reservation reservation = reservationService.getReservationById(id);
		if (reservation != null) {
			return new ResponseEntity<>(reservation, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
		Reservation createdReservation = reservationService.createReservation(reservation);
		return new ResponseEntity<>(createdReservation, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Reservation> updateReservation(@PathVariable Long id,
			@RequestBody Reservation updatedReservation) {
		Reservation updated = reservationService.updateReservation(id, updatedReservation);
		if (updated != null) {
			return new ResponseEntity<>(updated, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
		reservationService.deleteReservation(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
