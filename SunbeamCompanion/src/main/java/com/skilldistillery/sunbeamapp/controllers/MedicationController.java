package com.skilldistillery.sunbeamapp.controllers;

import java.util.List;

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

import com.skilldistillery.sunbeamapp.entities.Elder;
import com.skilldistillery.sunbeamapp.entities.Medication;
import com.skilldistillery.sunbeamapp.entities.User;
import com.skilldistillery.sunbeamapp.services.MedicationService;
import com.skilldistillery.sunbeamapp.services.UserService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost/" })
public class MedicationController {

	@Autowired
	private MedicationService medService;

	@Autowired
	private UserService userService;

	@GetMapping("meds/{medId}")
	public Medication getByMedicationId(@PathVariable Integer medId) {
		return medService.getMedicationById(medId);
	}

	@GetMapping("meds/elder/{elderId}")
	public List<Medication> getEldersMeds(@PathVariable Integer elderId){
		return medService.findMedicationsByElderId(elderId);
	}


	@PostMapping("meds")
	public Medication addMed(@RequestBody Medication med, HttpServletResponse res, String username, Elder medicatedElder) {
		Medication newMed = null;
		try {
			newMed = medService.addMedication(username, med, medicatedElder);
			res.setStatus(201); // successful creation
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
		return newMed;
	}

	@PutMapping("meds/{medId}")
	public Medication updateMed(@PathVariable int medId, @RequestBody Medication med, HttpServletResponse res, String username, Elder medicatedElder) {
		Medication updatedMed = null;
		try {
			updatedMed = medService.updateMedication(username, medId, med, medicatedElder);
			if (med == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			med = null;
		}
		return updatedMed;
	}
	
	@DeleteMapping("meds/{medId}")
	public void destroy(HttpServletResponse res, @PathVariable Integer medId, String username) {

		try {
			if (medService.deleteMedication(username, medId)) {
				res.setStatus(204);
			} else {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
	}

}
