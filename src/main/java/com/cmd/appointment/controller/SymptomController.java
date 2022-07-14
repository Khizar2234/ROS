package com.cmd.appointment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cmd.appointment.entities.Symptom;
import com.cmd.appointment.service.SymptomService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/ApppointmentService")
public class SymptomController {

	@Autowired
	private SymptomService symService;
	
	@PostMapping("/Symptom")
	@Operation(summary = "To add Symptom")
	public ResponseEntity<?> post(@RequestBody Symptom symptom) {
		ResponseEntity<?> response = null;
		try {
		response = new ResponseEntity<>(symService.addSymptom(symptom), HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response =  new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}
}
