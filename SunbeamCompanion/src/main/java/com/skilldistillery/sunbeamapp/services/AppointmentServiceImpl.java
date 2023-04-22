package com.skilldistillery.sunbeamapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.sunbeamapp.entities.Appointment;
import com.skilldistillery.sunbeamapp.repositories.AppointmentRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	
	@Autowired
	private AppointmentRepository apptRepo;
	
	@Override
	public List<Appointment> findAll() {
		return apptRepo.findAll();
	}
//	ADMIN 
	@Override
	public Appointment getApptByElderId(int elderId) {
		return apptRepo.findByElderAppointments(elderId);
	}

	@Override
	public Appointment getApptById(int apptId) {
		return apptRepo.findById(apptId);
	}

	@Override
	public Appointment create(Appointment appt) {
		return apptRepo.saveAndFlush(appt);
	}

	@Override
	public Appointment update(int apptId, Appointment appt) {
		Appointment existingAppt = apptRepo.findById(apptId);
		if(existingAppt != null) {
			existingAppt.setDescription(appt.getDescription());
			existingAppt.setApptDate(appt.getApptDate());
			existingAppt.setApptTime(appt.getApptTime());
			existingAppt.setTitle(appt.getTitle());
			existingAppt.setLocation(appt.getLocation());
			return apptRepo.saveAndFlush(existingAppt);
		}
		return null;
	}

	@Override
	public boolean delete(int apptId) {
		boolean deleted = false;
		Appointment apptToDelete = apptRepo.findById(apptId);
		if(apptToDelete != null) {
			apptRepo.delete(apptToDelete);
			deleted = true;
		}
		return deleted;
	}


	
}
