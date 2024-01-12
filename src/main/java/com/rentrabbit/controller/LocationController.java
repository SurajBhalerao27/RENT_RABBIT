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

import com.rentrabbit.model.Location;
import com.rentrabbit.serviceImpl.LocationServiceImpl;

@RestController
@RequestMapping("/locations")
public class LocationController {

	@Autowired
	LocationServiceImpl locationService;

	@GetMapping
	public ResponseEntity<List<Location>> getAllLocations() {
		List<Location> locations = locationService.getAllLocations();
		return new ResponseEntity<>(locations, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Location> getLocationById(@PathVariable Long id) {
		Location location = locationService.getLocationById(id);
		if (location != null) {
			return new ResponseEntity<>(location, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<Location> createLocation(@RequestBody Location location) {
		Location createdLocation = locationService.createLocation(location);
		return new ResponseEntity<>(createdLocation, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Location> updateLocation(@PathVariable Long id, @RequestBody Location updatedLocation) {
		Location updated = locationService.updateLocation(id, updatedLocation);
		if (updated != null) {
			return new ResponseEntity<>(updated, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteLocation(@PathVariable Long id) {
		locationService.deleteLocation(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
