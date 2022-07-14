package com.cmd.appointment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cmd.appointment.exception.AppointmentNotFoundException;
import com.cmd.appointment.repository.FeedbackRepository;
import com.cmd.appointment.service.FeedbackService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/FeedbackController")
public class FeedbackController {

	@Autowired
	private FeedbackService fbservice;
	
	@GetMapping("/ViewFeedback/{id}")
	@Operation(summary = "To view Feedback For Appointment")
	public ResponseEntity<?> getFeedback(@RequestParam(value = "id") long id) {
		ResponseEntity<?> response = null;
			try {
				response = new ResponseEntity<>(fbservice.getFeedbackByAppointmentId(id), HttpStatus.OK);
			} catch (AppointmentNotFoundException e) {
				// TODO Auto-generated catch block
				response =  new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
			}
		return response;
	}
}
