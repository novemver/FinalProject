package com.skilldistillery.sunbeamapp.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.sunbeamapp.services.MedicationService;

@RestController
@CrossOrigin({ "*", "http://localhost/" })
public class MedicationController {

	private MedicationService medicationService;
}
