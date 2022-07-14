package com.cmd.appointment.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmd.appointment.dtos.AppointmentDto;
import com.cmd.appointment.entities.Appointment;
import com.cmd.appointment.exception.AppointmentAlreadyExistException;
import com.cmd.appointment.exception.AppointmentNotFoundException;
import com.cmd.appointment.mapper.AppointmentMapper;
import com.cmd.appointment.repository.AppointmentRepository;

import com.cmd.appointment.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepository aprepo;
	
	@Autowired
	private AppointmentMapper appointmentMapper;

	@Override
	public Appointment saveAppointment(Appointment appointment) throws AppointmentAlreadyExistException {
		// TODO Auto-generated method stub
		Appointment appointment1 = null;
		if (aprepo.existsById(appointment.getAppointmentId())) {
			throw new AppointmentAlreadyExistException("Appointment already exists");
		} else {
			appointment1 = aprepo.save(appointment);
		}
		return appointment1;
	}

	@Override
	public int viewAcceptedAppointment() throws AppointmentNotFoundException {
		// TODO Auto-generated method stub
		List<Appointment> appointments = aprepo.getAcceptedAppointmrents();
		int aa = 0;
		if (appointments.isEmpty()) {
			throw new AppointmentNotFoundException("No appointments exist");
		} else {
			aa = appointments.size();
		}
		return aa;
	}

	@Override
	public int viewCancelledAppointment() throws AppointmentNotFoundException {
		// TODO Auto-generated method stub
		int ac = 0;
		List<Appointment> appointments = aprepo.getCancelledAppointmrents();
		if (appointments.isEmpty()) {
			throw new AppointmentNotFoundException("No appointments exist");
		} else {
			ac = appointments.size();
		}

		return ac;
	}

	@Override
	public List<AppointmentDto> viewAllAppointments() throws AppointmentNotFoundException {
		// TODO Auto-generated method stub
		List<Appointment> appointments = aprepo.getAllAppointments();
		if (appointments.isEmpty()) {
			throw new AppointmentNotFoundException("No appointments exist");
		}
		else {
			AppointmentDto appointmentDto = new AppointmentDto();
			List<AppointmentDto> appointmentDtos = new ArrayList<AppointmentDto>();
			for(Appointment appointment : appointments) {
				appointmentDto = appointmentMapper.convertToDto(appointment);
				appointmentDtos.add(appointmentDto);
			}
			return appointmentDtos;
		}
	}

	@Override
	public List<AppointmentDto> viewFilterAppointments(String status) throws AppointmentNotFoundException {
		// TODO Auto-generated method stub
		List<Appointment> appointments = aprepo.getFilteredAppointments(status);
		if (appointments.isEmpty()) {
			throw new AppointmentNotFoundException("No appointments exist");
		}
		else {
			AppointmentDto appointmentDto = new AppointmentDto();
			List<AppointmentDto> appointmentDtos = new ArrayList<AppointmentDto>();
			for(Appointment appointment : appointments) {
				appointmentDto = appointmentMapper.convertToDto(appointment);
				appointmentDtos.add(appointmentDto);
			}
			return appointmentDtos;
		}
	}

	public Appointment AcceptAppointment(long id) throws AppointmentNotFoundException {
		// TODO Auto-generated method stub
		Appointment appointment = null;
		if (aprepo.existsById(id)) {
			appointment = aprepo.findById(id).get();
			appointment.setStatus("Accepted");
			aprepo.save(appointment);
		} else {
			throw new AppointmentNotFoundException("Appointment not found");
		}
		return appointment;
	}

	@Override
	public Appointment CancelAppointment(long id) throws AppointmentNotFoundException {
		// TODO Auto-generated method stub
		Appointment appointment = null;
		if (aprepo.existsById(id)) {
			appointment = aprepo.findById(id).get();
			appointment.setStatus("Cancelled");
			aprepo.save(appointment);
		} else {
			throw new AppointmentNotFoundException("Appointment not found");
		}
		return appointment;
	}

	@Override
	public Appointment CloseAppointment(long id) throws AppointmentNotFoundException {
		// TODO Auto-generated method stub
		Appointment appointment = null;
		if (aprepo.existsById(id)) {
			appointment = aprepo.findById(id).get();
			appointment.setStatus("Closed");
			aprepo.save(appointment);
		} else {
			throw new AppointmentNotFoundException("Appointment not found");
		}
		return appointment;
	}

	@Override
	public List<AppointmentDto> viewCancelledAppointment(long id) throws AppointmentNotFoundException {
		// TODO Auto-generated method stub
		List<Appointment> appointments = aprepo.viewCancelledAppointments(id);
		if(appointments.isEmpty()) {
			throw new AppointmentNotFoundException("No appointments exist");
		}
		else {
			AppointmentDto appointmentDto = new AppointmentDto();
			List<AppointmentDto> appointmentDtos = new ArrayList<AppointmentDto>();
			for(Appointment appointment : appointments) {
				appointmentDto = appointmentMapper.convertToDto(appointment);
				appointmentDtos.add(appointmentDto);
			}
			return appointmentDtos;
		}
	}

	@Override
	public List<AppointmentDto> viewPendingAppointment(long id) throws AppointmentNotFoundException {
		// TODO Auto-generated method stub
		List<Appointment> appointments = aprepo.viewPendingAppointments(id);
		if(appointments.isEmpty()) {
			throw new AppointmentNotFoundException("No appointments exist");
		}
		else {
			AppointmentDto appointmentDto = new AppointmentDto();
			List<AppointmentDto> appointmentDtos = new ArrayList<AppointmentDto>();
			for(Appointment appointment : appointments) {
				appointmentDto = appointmentMapper.convertToDto(appointment);
				appointmentDtos.add(appointmentDto);
			}
			return appointmentDtos;
		}
	}

	@Override
	public List<AppointmentDto> viewAllAppointments(long id) throws AppointmentNotFoundException {
		// TODO Auto-generated method stub
		List<Appointment> appointments = aprepo.viewAllAppointments(id);
		if(appointments.isEmpty()) {
			throw new AppointmentNotFoundException("No appointments exist");
		}
		
		AppointmentDto appointmentDto = new AppointmentDto();
		List<AppointmentDto> appointmentDtos = new ArrayList<AppointmentDto>();
		for(Appointment appointment : appointments) {
			appointmentDto = appointmentMapper.convertToDto(appointment);
			appointmentDtos.add(appointmentDto);
		}
		return appointmentDtos;
	}

	@Override
	public List<AppointmentDto> viewAcceptedAppointment(long id) throws AppointmentNotFoundException {
		List<Appointment> appointments = aprepo.viewAccptedAppointments(id);
		if(appointments.isEmpty()) {
			throw new AppointmentNotFoundException("No appointments exist");
		}
		else {
			AppointmentDto appointmentDto = new AppointmentDto();
			List<AppointmentDto> appointmentDtos = new ArrayList<AppointmentDto>();
			for(Appointment appointment : appointments) {
				appointmentDto = appointmentMapper.convertToDto(appointment);
				appointmentDtos.add(appointmentDto);
			}
			return appointmentDtos;
		}
	}

	@Override
	public List<AppointmentDto> viewClosedAppointment(long id) throws AppointmentNotFoundException {
		List<Appointment> appointments = aprepo.viewClosedAppointments(id);
		if(appointments.isEmpty()) {
			throw new AppointmentNotFoundException("No appointments exist");
		}
		else {
			AppointmentDto appointmentDto = new AppointmentDto();
			List<AppointmentDto> appointmentDtos = new ArrayList<AppointmentDto>();
			for(Appointment appointment : appointments) {
				appointmentDto = appointmentMapper.convertToDto(appointment);
				appointmentDtos.add(appointmentDto);
			}
			return appointmentDtos;
		}
	}

	@Override
	public List<AppointmentDto> ViewAllAppointmentsForTheDay(long id, String date) throws AppointmentNotFoundException {

		List<Appointment> appointments = aprepo.viewAppointmentsForDay(date, id);
		if(appointments.isEmpty()) {
			throw new AppointmentNotFoundException("No appointments exist");
		}
		else {
			AppointmentDto appointmentDto = new AppointmentDto();
			List<AppointmentDto> appointmentDtos = new ArrayList<AppointmentDto>();
			for(Appointment appointment : appointments) {
				appointmentDto = appointmentMapper.convertToDto(appointment);
				appointmentDtos.add(appointmentDto);
			}
			return appointmentDtos;
		}
	}

}
