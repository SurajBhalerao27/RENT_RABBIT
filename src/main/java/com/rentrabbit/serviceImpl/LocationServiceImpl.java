package com.rentrabbit.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentrabbit.model.Location;
import com.rentrabbit.repository.LocationRepository;
import com.rentrabbit.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	LocationRepository locationRepository;

	public List<Location> getAllLocations() {
		return locationRepository.findAll();
	}

	public Location getLocationById(Long id) {
		Optional<Location> optionalLocation = locationRepository.findById(id);
		return optionalLocation.orElse(null);
	}

	public Location createLocation(Location location) {
		return locationRepository.save(location);
	}

	public Location updateLocation(Long id, Location updatedLocation) {
		Optional<Location> optionalLocation = locationRepository.findById(id);
		if (optionalLocation.isPresent()) {
			Location existingLocation = optionalLocation.get();
			// Update fields based on your requirements
//            existingLocation.setCity(updatedLocation.getCity());
//            existingLocation.setCountry(updatedLocation.getCountry());
			// Update other fields as needed
			return locationRepository.save(existingLocation);
		}
		return null; // Location with the given id not found
	}

	public void deleteLocation(Long id) {
		locationRepository.deleteById(id);
	}
}
