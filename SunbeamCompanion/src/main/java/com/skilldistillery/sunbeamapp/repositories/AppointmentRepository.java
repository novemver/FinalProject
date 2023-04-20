package com.skilldistillery.sunbeamapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.sunbeamapp.entities.Appointment;
import com.skilldistillery.sunbeamapp.entities.Elder;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

	Appointment findAppointmentByElderId(int elderId);
}