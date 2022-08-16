package com.cmd.appointment.service;

import java.util.List;

import com.cmd.appointment.dtos.AppointmentDto;
import com.cmd.appointment.entities.Appointment;
import com.cmd.appointment.entities.Patient;
import com.cmd.appointment.exception.AppointmentAlreadyExistException;
import com.cmd.appointment.exception.AppointmentNotFoundException;

public interface AppointmentService {

	public List<Appointment> getAllAppointment();
	
	public int viewAllAcceptedAppointmentSummary() throws AppointmentNotFoundException;

	public int viewCancelledAppointmentSummary() throws AppointmentNotFoundException;

	public List<AppointmentDto> viewAllAppointmentsDTO() throws AppointmentNotFoundException;

	public List<AppointmentDto> viewFilterAppointmentsDTO(String status) throws AppointmentNotFoundException;

	public List<AppointmentDto> viewAcceptedAppointment(long id) throws AppointmentNotFoundException;

	public List<AppointmentDto> viewCancelledAppointment(long id) throws AppointmentNotFoundException;

	public List<AppointmentDto> viewPendingAppointment(long id) throws AppointmentNotFoundException;

	public List<AppointmentDto> ViewAllAppointmentsForTheDay(long id, String date) throws AppointmentNotFoundException;

	public List<Appointment> viewAllAppointmentsByDoctorId(long id1) throws AppointmentNotFoundException;
	
	public List<AppointmentDto> viewClosedAppointment(long id) throws AppointmentNotFoundException;

	public Appointment AcceptAppointment(long id) throws AppointmentNotFoundException;

	public Appointment CancelAppointment(long id) throws AppointmentNotFoundException;

	public Appointment CloseAppointment(long id) throws AppointmentNotFoundException;

	public Appointment saveAppointment(long patientId, long docId, Appointment appointment)
			throws AppointmentAlreadyExistException;

	

}
