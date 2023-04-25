package com.skilldistillery.sunbeamapp.services;

import java.util.List;

import com.skilldistillery.sunbeamapp.entities.Appointment;

public interface AppointmentService {
	
	public List <Appointment> findAll();
	public Appointment getApptById(int apptId);
	public Appointment getApptByElderId(int elderId);
	public Appointment getApptByUserId(int userId);
	public Appointment create(String username, Appointment appt , int elderId);
	public Appointment update(String username, int apptId, Appointment appt);
	public boolean delete(String username, int apptId);
	
}
