package com.skilldistillery.sunbeamapp.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.sunbeamapp.entities.Appointment;
import com.skilldistillery.sunbeamapp.services.AppointmentService;
import com.skilldistillery.sunbeamapp.services.ElderService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost/" })
public class AppointmentController {
	
	@Autowired
	private AppointmentService apptService;

	@Autowired
	private ElderService elderService;
	
	@GetMapping("appointments")
	public List<Appointment> getListOfAppointments(){
		return apptService.findAll();
	}
	
	@GetMapping("appointments/{apptId}")
	public Appointment findApptById(@PathVariable Integer apptId) {
		return apptService.getApptById(apptId);
	}
	
	@PostMapping("elders/{elderId}/appointments")
	public Appointment addAppointment(@RequestBody Appointment appt,@PathVariable Integer elderId, HttpServletResponse res,
			HttpServletRequest req, Principal principal) {
		try {
			appt = apptService.create(principal.getName(), appt, elderId);
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
	@PutMapping("elders/{elderId}/appointments/{apptId}")
	public Appointment updateAppt(@PathVariable Integer apptId, @PathVariable Integer elderId,
			@RequestBody Appointment appt, HttpServletResponse res, Principal principal) {
		try {
			appt = apptService.update(principal.getName(), apptId, appt, elderId);
			if (appt == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			appt = null;
		}
		return appt;
	
	}
	
	@DeleteMapping("elders/{elderId}/appointments/{apptId}")
	public void deleteAppointment(@PathVariable Integer apptId, @PathVariable Integer elderId, 
			HttpServletResponse res, Principal principal) {
		try { 
			if(apptService.delete(principal.getName(), apptId, elderId)) {
				res.setStatus(204);
			} else {
				res.setStatus(404);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
		
	}

}
