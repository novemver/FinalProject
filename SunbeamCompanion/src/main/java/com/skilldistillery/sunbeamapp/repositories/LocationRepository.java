package com.skilldistillery.sunbeamapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.sunbeamapp.entities.Location;
import com.skilldistillery.sunbeamapp.entities.User;

public interface LocationRepository extends JpaRepository<Location, Integer>{

	Location findById(int id);

}
