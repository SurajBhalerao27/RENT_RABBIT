package com.rentrabbit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentrabbit.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
