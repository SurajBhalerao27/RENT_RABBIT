package com.rentrabbit.service;

import java.util.List;

import com.rentrabbit.model.Car;

public interface CarService {
	List<Car> getAllCars();

	Car getCarById(Long id);

	Car createCar(Car car);

	Car updateCar(Long id, Car updatedCar);

	void deleteCar(Long id);
}
