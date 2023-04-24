package com.skilldistillery.sunbeamapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.sunbeamapp.entities.Appointment;
import com.skilldistillery.sunbeamapp.entities.Elder;
import com.skilldistillery.sunbeamapp.entities.FamilyMember;
import com.skilldistillery.sunbeamapp.entities.User;
import com.skilldistillery.sunbeamapp.repositories.AppointmentRepository;
import com.skilldistillery.sunbeamapp.repositories.ElderRepository;
import com.skilldistillery.sunbeamapp.repositories.FamilyMemberRepository;
import com.skilldistillery.sunbeamapp.repositories.UserRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	
	@Autowired
	private AppointmentRepository apptRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ElderRepository elderRepo;
	@Autowired
	private FamilyMemberRepository familyRepo;
	
	
	
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
	public Appointment create(String username, Appointment appt, int elderId) {
		User loggedInUser = userRepo.findByUsername(username);
		Elder currentElder = elderRepo.findById(elderId);
		if(loggedInUser != null && currentElder != null  ) {
			appt.setUserAppointments(loggedInUser);
			appt.setElderAppointments(currentElder);
			return apptRepo.saveAndFlush(appt);
		}
		return null;
	}

	@Override
	public Appointment update(String username, int apptId, Appointment appt, int elderId) {
		User loggedInUser = userRepo.findByUsername(username);
		if(loggedInUser == null) {
			return null;
		}
		FamilyMember family = familyRepo.findByElder_IdAndUser_Id(elderId, loggedInUser.getId());
		Elder currentElder = elderRepo.findById(elderId);
		Appointment existingAppt = apptRepo.findById(apptId);
		if(existingAppt != null && loggedInUser!= null && currentElder != null && family != null
			&& (currentElder.getElderCaretakers().contains(loggedInUser) || currentElder.getFamilyMembers().contains(family))) {
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
	public boolean delete(String username, int apptId) {
		boolean deleted = false;
		Appointment apptToDelete = apptRepo.findById(apptId);
		if(apptToDelete != null) {
			apptRepo.delete(apptToDelete);
			deleted = true;
		}
		return deleted;
	}
	@Override
	public Appointment getApptByUserId(int userId) {
		return apptRepo.findByUserAppointments(userId);
	}


	
}
