package com.skilldistillery.sunbeamapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.sunbeamapp.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Integer>{

}
