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

	@Override
	public Appointment getApptById(Appointment appt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Appointment create(Appointment appt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Appointment update(int apptId, Appointment appt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int apptId) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
