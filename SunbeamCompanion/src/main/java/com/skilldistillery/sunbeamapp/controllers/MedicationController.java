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
import com.skilldistillery.sunbeamapp.services.MedicationService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost/" })
public class MedicationController {

	@Autowired
	private MedicationService medService;

	@GetMapping("meds/{medId}")
	public Medication getByMedicationId(@PathVariable Integer medId) {
		return medService.getMedicationById(medId);
	}



	@PostMapping("meds")
	public Medication addMed(@RequestBody Medication med, HttpServletResponse res) {
		Medication newMed = null;
		try {
			newMed = medService.addMedication(med);
			res.setStatus(201); // successful creation
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
		return newMed;
	}

	@PutMapping("meds/{medId}")
	public Medication updateElder(@PathVariable int medId, @RequestBody Medication med, HttpServletResponse res) {
		Medication updatedMed = null;
		try {
			updatedMed = medService.updateMedication(medId, med);
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
	public void destroy(HttpServletResponse res, @PathVariable int medId) {

		try {
			if (medService.deleteMedication(medId)) {
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
