package com.rentrabbit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentrabbit.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
