package com.skilldistillery.sunbeamapp.services;

import java.util.List;

import com.skilldistillery.sunbeamapp.entities.Appointment;
import com.skilldistillery.sunbeamapp.entities.Location;

public interface LocationService {

	public Location getLocationById(int locId);
	
	public Location getByLocApptId(int apptId);
	
	public List<Location> findAllLocationsByApptId(int apptId);
	
	public Location addLocation(String username, Location location, int apptId, int locId);
	
	public Location updateLocation(String username, Location location, int locId, Appointment appt);

	public boolean deleteLocation(String username, int locId);

}
