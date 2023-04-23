package com.skilldistillery.sunbeamapp.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.sunbeamapp.entities.Elder;
import com.skilldistillery.sunbeamapp.entities.Medication;
import com.skilldistillery.sunbeamapp.services.ElderService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost/" })
public class ElderController {

	@Autowired
	private ElderService elderService;

	@GetMapping("elders/{elderId}")
	public Elder findElderById(@PathVariable Integer elderId, HttpServletResponse res) {
		return elderService.getByElderId(elderId);
	}

	@GetMapping("elders")
	public List<Elder> getListOfElder() {
		return elderService.findAllElders();
	}

	@GetMapping("elders/meds/{elderId}")
	public List<Elder> getAllMedicationsForElder(@PathVariable int elderId) {
		return elderService.getAllMedication(elderId);
	}

	@PostMapping("elders")
	public Elder createElder(@RequestBody Elder elder, HttpServletResponse res) {
		Elder newElder = null;
		try {
			newElder = elderService.addElder(elder);
			res.setStatus(201); // successful creation
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
		return newElder;
	}

	@PutMapping("elders/{elderId}")
	public Elder updateElder(@PathVariable int elderId, @RequestBody Elder elder, HttpServletRequest req,
			HttpServletResponse res) {
		Elder updatedElder = null;
		try {
//			principal allows us to verify that the user is updating themselves
			updatedElder = elderService.updateElder(elderId, elder);
			if (elder == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			elder = null;
		}
		return updatedElder;
	}

	@DeleteMapping("elders/{elderId}")
	public Elder archiveUser(@PathVariable int elderId, HttpServletResponse res) {
		Elder archived = elderService.getByElderId(elderId);
		if (elderService.archiveElder(elderId)) {
			res.setStatus(200);
		} else {
			res.setStatus(404);
		}
		return archived;
	}

	@PatchMapping("elders/{elderId}")
	public Elder unarchiveUser(@PathVariable int elderId, HttpServletResponse res) {
		Elder unArchive = elderService.getByElderId(elderId);
		if (elderService.unarchiveElder(elderId)) {
			res.setStatus(200);
		} else {
			res.setStatus(404);
		}
		return unArchive;
	}

}
