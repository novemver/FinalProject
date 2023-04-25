package com.skilldistillery.sunbeamapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.sunbeamapp.entities.Appointment;
import com.skilldistillery.sunbeamapp.entities.Location;
import com.skilldistillery.sunbeamapp.entities.User;
import com.skilldistillery.sunbeamapp.repositories.AppointmentRepository;
import com.skilldistillery.sunbeamapp.repositories.LocationRepository;
import com.skilldistillery.sunbeamapp.repositories.UserRepository;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepository locRepo;

	@Autowired
	private AppointmentRepository apptRepo;

	@Autowired
	private UserRepository userRepo;

	@Override
	public Location getLocationById(int locId) {
		// TODO Auto-generated method stub
		return locRepo.findById(locId);
	}

	@Override
	public Location getByLocApptId(int apptId) {
		Appointment appt = apptRepo.findById(apptId);
		return locRepo.findLocation_ByAppointmentLocations(appt.getId());
	}

	@Override
	public List<Location> findAllLocationsByApptId(int apptId) {
		Appointment appt = apptRepo.findById(apptId);
		return (List<Location>) locRepo.findLocation_ByAppointmentLocations(appt.getId());
	}

	@Override
	public Location addLocation(String username, Location location, int apptId, int locId) {
		User loggedInUser = userRepo.findByUsername(username);
		if (loggedInUser != null) {

			return locRepo.saveAndFlush(location);
		}
		return null;
	}

	@Override
	public Location updateLocation(String username, Location location, int locId, Appointment appt) {
		User loggedInUser = userRepo.findByUsername(username);
		if (loggedInUser == null) {
			return null;
		}
		Optional<Appointment> apptLoc = apptRepo.findById(appt.getId());
		Location existingLocation = locRepo.findById(locId);
		if (existingLocation != null && apptLoc != null) {
			existingLocation.setName(location.getName());
			existingLocation.setAddress(location.getAddress());
			existingLocation.setCity(location.getCity());
			existingLocation.setState(location.getState());
			existingLocation.setZipcode(location.getZipcode());
			return locRepo.saveAndFlush(existingLocation);
		}
		return null;
	}

	@Override
	public boolean deleteLocation(String username, int locId) {
		boolean deleted = false;
		Location toDelete = locRepo.findById(locId);
		if (toDelete != null) {
			locRepo.delete(toDelete);
			deleted = true;
		}
		return deleted;
	}

}
