package com.cmd.appointment.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cmd.appointment.entities.Appointment;
import com.cmd.appointment.exception.AppointmentAlreadyExistException;
import com.cmd.appointment.exception.AppointmentNotFoundException;
import com.cmd.appointment.service.AppointmentService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/ApppointmentService")
public class AppointmentController {

	@Autowired
	private AppointmentService appService;

	@PostMapping("/Appointment")
	@Operation(summary = "to save appointment")
	public ResponseEntity<?> postAppointment(@RequestBody Appointment appointment) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(appService.saveAppointment(appointment), HttpStatus.OK);
		} catch (AppointmentAlreadyExistException e) {
			// TODO Auto-generated catch block
			response =  new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}

	@GetMapping("/Appointment/AcceptedAppointments")
	@Operation(summary = "to get accepted appointment list")
	public ResponseEntity<?> getAcceptedAppointment() {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(appService.viewAcceptedAppointment(), HttpStatus.OK);
		} catch (AppointmentNotFoundException e) {
			// TODO Auto-generated catch block
			response =  new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}

	@GetMapping("/Appointment/Cancelledappointments")
	@Operation(summary = "to get cancelled appointment list")
	public ResponseEntity<?> getCancelledRequest() {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(appService.viewCancelledAppointment(), HttpStatus.OK);
		} catch (AppointmentNotFoundException e) {
			// TODO Auto-generated catch block
			response =  new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}

	@GetMapping("/Appointment/{status}")
	@Operation(summary = "to get filtered appointment list")
	public ResponseEntity<?> getFilteredRequest(@PathVariable(value = "status") String status) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(appService.viewFilterAppointments(status), HttpStatus.OK);
		} catch (AppointmentNotFoundException e) {
			// TODO Auto-generated catch block
			response =  new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}

	@GetMapping("/Appointments/{id}")
	@Operation(summary = "to get All appointment list")
	public ResponseEntity<?> getAllRequest(@PathVariable(value = "id") long id) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(appService.viewAllAppointments(id), HttpStatus.OK);
		} catch (AppointmentNotFoundException e) {
			// TODO Auto-generated catch block
			response =  new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}

	@PutMapping("/acceptAppointment/{id}")
	@Operation(summary = "To accept Appointment")
	public ResponseEntity<?> accpetAppointment(@PathVariable(value = "id") long id) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(appService.AcceptAppointment(id), HttpStatus.OK);
		} catch (AppointmentNotFoundException e) {
			// TODO Auto-generated catch block
			response =  new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}

		return response;
	}

	@PutMapping("/CloseAppointment/{id}")
	@Operation(summary = "To Close Appointment")
	public ResponseEntity<?> CloseAppointment(@PathVariable(value = "id") long id) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(appService.CloseAppointment(id), HttpStatus.OK);
		} catch (AppointmentNotFoundException e) {
			// TODO Auto-generated catch block
			response =  new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}

		return response;
	}

	@PutMapping("/CancelAppointment/{id}")
	@Operation(summary = "To Cancel Appointment")
	public ResponseEntity<?> CancelAppointment(@PathVariable(value = "id") long id) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(appService.CancelAppointment(id), HttpStatus.OK);
		} catch (AppointmentNotFoundException e) {
			// TODO Auto-generated catch block
			response =  new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}

		return response;
	}

	@GetMapping("/ViewAllAppointments/{id}")
	@Operation(summary = "To view all appointments")
	public ResponseEntity<?> getAllAppointments(@PathVariable(value = "id") long id) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(appService.viewAllAppointments(id), HttpStatus.OK);
		} catch (AppointmentNotFoundException e) {
			// TODO Auto-generated catch block
			response =  new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}

	@GetMapping("/ViewAcceptedAppointments/{id}")
	@Operation(summary = "To view all appointments")
	public ResponseEntity<?> getAcceptedAppointments(@PathVariable(value = "id") long id) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(appService.viewAcceptedAppointment(id), HttpStatus.OK);
		} catch (AppointmentNotFoundException e) {
			// TODO Auto-generated catch block
			response =  new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}

	@GetMapping("/ViewPendingAppointments/{id}")
	@Operation(summary = "To view all appointments")
	public ResponseEntity<?> getPendingAppointments(@PathVariable(value = "id") long id) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(appService.viewPendingAppointment(id), HttpStatus.OK);
		} catch (AppointmentNotFoundException e) {
			// TODO Auto-generated catch block
			response =  new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}

	@GetMapping("/ViewCancelledAppointments/{id}")
	@Operation(summary = "To view all appointments")
	public ResponseEntity<?> getCancelledAppointments(@PathVariable(value = "id") long id) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(appService.viewCancelledAppointment(id), HttpStatus.OK);
		} catch (AppointmentNotFoundException e) {
			// TODO Auto-generated catch block
			response =  new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}

	@GetMapping("/ViewClosedAppointments/{id}")
	@Operation(summary = "To view all appointments")
	public ResponseEntity<?> getClosedAppointments(@PathVariable(value = "id") long id) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(appService.viewClosedAppointment(id), HttpStatus.OK);
		} catch (AppointmentNotFoundException e) {
			// TODO Auto-generated catch block
			response =  new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}

	@GetMapping("/ViewAppointmentsForDay/{id}/{date}")
	@Operation(summary = "To view all appointments For The Day")
	public ResponseEntity<?> getAppointmentsForDay(@PathVariable(value = "id") long id,
			@PathVariable(value = "date") String date) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(appService.ViewAllAppointmentsForTheDay(id, date), HttpStatus.OK);
		} catch (AppointmentNotFoundException e) {
			// TODO Auto-generated catch block
			response =  new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}
}
