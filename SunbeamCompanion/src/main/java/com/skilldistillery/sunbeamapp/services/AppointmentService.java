package com.skilldistillery.sunbeamapp.services;

import java.util.List;

import com.skilldistillery.sunbeamapp.entities.Appointment;

public interface AppointmentService {
	
	public List <Appointment> findAll();
	public Appointment getApptById(int apptId);
	public Appointment getApptByElderId(int elderId);
	public Appointment create(Appointment appt);
	public Appointment update(int apptId, Appointment appt);
	public boolean delete(int apptId);
	
}
