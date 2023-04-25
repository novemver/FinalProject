package com.skilldistillery.sunbeamapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.sunbeamapp.entities.Appointment;
import com.skilldistillery.sunbeamapp.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Integer>{

	Location findById(int locId);
	
	Location findLocation_ByAppointmentLocations(int apptId);
	
//	Location findByCategory(int catId);
	
	List<Location> findByAppointmentLocations(Appointment appointmentLocations);

	

}
