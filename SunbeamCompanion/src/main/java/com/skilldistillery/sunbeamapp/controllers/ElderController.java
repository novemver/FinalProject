package com.skilldistillery.sunbeamapp.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.sunbeamapp.entities.Elder;
import com.skilldistillery.sunbeamapp.services.ElderService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost/" })
public class ElderController {

	@Autowired
	private ElderService elderService;
	
	@GetMapping("elders")
	public List<Elder> getListOfElder(){
		
		return elderService.findAllElders();
	}
	
	@PutMapping("elders/{elderId}")
	public Elder updateElder(@PathVariable int elderId, @RequestBody Elder elder, HttpServletRequest req,
			HttpServletResponse res) {
			Elder updatedElder = null;
		try {
//			principal allows us to verify that the user is updating themselves
			updatedElder =	elderService.updateElder(elderId, elder);
			if 	(elder == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			elder = null;
		}
		return	updatedElder;
	}
	
	
	
	
	
}
