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

import com.rentrabbit.model.Car;
import com.rentrabbit.serviceImpl.CarServiceImpl;

@RestController
@RequestMapping("/cars")
public class CarController {

	@Autowired
	CarServiceImpl carService;

	@GetMapping
	public ResponseEntity<List<Car>> getAllCars() {
		List<Car> cars = carService.getAllCars();
		return new ResponseEntity<>(cars, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Car> getCarById(@PathVariable Long id) {
		Car car = carService.getCarById(id);
		if (car != null) {
			return new ResponseEntity<>(car, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<Car> createCar(@RequestBody Car car) {
		Car createdCar = carService.createCar(car);
		return new ResponseEntity<>(createdCar, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car updatedCar) {
		Car updated = carService.updateCar(id, updatedCar);
		if (updated != null) {
			return new ResponseEntity<>(updated, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
		carService.deleteCar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
