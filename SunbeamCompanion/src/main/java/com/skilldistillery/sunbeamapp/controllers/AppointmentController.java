package com.skilldistillery.sunbeamapp.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.sunbeamapp.entities.Appointment;
import com.skilldistillery.sunbeamapp.services.AppointmentService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost/" })
public class AppointmentController {
	
	@Autowired
	private AppointmentService apptService;

	@GetMapping("appointments")
	public List<Appointment> getListOfAppointments(){
		return apptService.findAll();
	}
	
	@GetMapping("appointments/{apptId}")
	public Appointment findApptById(@PathVariable Integer apptId) {
		return apptService.getApptById(apptId);
	}
	
	@PostMapping("appointments")
	public Appointment addAppointment(@RequestBody Appointment appt, HttpServletResponse res,
			HttpServletRequest req) {
		try {
			appt = apptService.create(appt);
			System.out.println("******************************"+ appt);
			res.setStatus(201);
			StringBuffer url = req.getRequestURL();
			url.append("/").append(appt.getId());
			res.setHeader("Location", url.toString());
		}catch(Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			appt = null;
			
		}
		return appt;
	}
}
