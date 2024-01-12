package com.rentrabbit.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentrabbit.exceptions.CarNotFoundException;
import com.rentrabbit.model.Car;
import com.rentrabbit.repository.CarRepository;
import com.rentrabbit.service.CarService;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	CarRepository carRepository;

	public List<Car> getAllCars() {
		return carRepository.findAll();
	}

	public Car getCarById(Long id) {
		Optional<Car> optionalCar = carRepository.findById(id);
		return optionalCar.orElseThrow(() -> new CarNotFoundException("Please Enter Proper Id of the car"));
	}

	public Car createCar(Car car) {
		return carRepository.save(car);
	}

	public Car updateCar(Long id, Car updatedCar) {
		Optional<Car> optionalCar = carRepository.findById(id);
		if (optionalCar.isPresent()) {
			Car existingCar = optionalCar.get();
			existingCar.setModel(updatedCar.getModel());
			existingCar.setMake(updatedCar.getMake());
			existingCar.setYear(updatedCar.getYear());
			return carRepository.save(existingCar);
		}
		return null;
	}

	public void deleteCar(Long id) {
		carRepository.deleteById(id);
	}
}
