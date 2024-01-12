package com.rentrabbit.service;

import java.util.List;

import com.rentrabbit.model.Location;

public interface LocationService {
	List<Location> getAllLocations();

	Location getLocationById(Long id);

	Location createLocation(Location location);

	Location updateLocation(Long id, Location updatedLocation);

	void deleteLocation(Long id);
}
