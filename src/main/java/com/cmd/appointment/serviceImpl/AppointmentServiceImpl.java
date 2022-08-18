package com.cmd.appointment.serviceImpl;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cmd.appointment.dtos.AppointmentDto;
import com.cmd.appointment.entities.Appointment;
import com.cmd.appointment.entities.Doctor;
import com.cmd.appointment.entities.Patient;
import com.cmd.appointment.exception.AppointmentAlreadyExistException;
import com.cmd.appointment.exception.AppointmentNotFoundException;
import com.cmd.appointment.exception.DoctorNotFoundException;
import com.cmd.appointment.mapper.AppointmentMapper;
import com.cmd.appointment.repository.AppointmentRepository;
import com.cmd.appointment.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepository aprepo;

	@Autowired
	private AppointmentMapper appointmentMapper;

	@Autowired
	private RestTemplate restTemplate;

	public AppointmentServiceImpl(AppointmentRepository appRepo) {
		// TODO Auto-generated constructor stub
	}

	String baseURL = "http://localhost:8001";

	@Override
	public List<Appointment> getAllAppointment() {
		// TODO Auto-generated method stub
		List<Appointment> appointments = aprepo.getAllAppointments();
		return appointments;
	}

	@Override
	public Appointment saveAppointment(long patientId, long docId, Appointment appointment)
			throws AppointmentAlreadyExistException, DoctorNotFoundException {
		// TODO Auto-generated method stub

//			Doctor doctor = docRepo.findById(docId).get();
//			appointment.setDoctor(doctor);
		String URL = "http://localhost:8094/setting/settings_patient/getPatients";

		ResponseEntity<Patient[]> response = restTemplate.getForEntity(URL, Patient[].class);
		Patient[] patients = response.getBody();

		String URL1 = "http://localhost:8094/setting/settings_doctor/getDoctor";

		ResponseEntity<Doctor[]> response1 = restTemplate.getForEntity(URL1, Doctor[].class);
		Doctor[] doctors = response1.getBody();

		for (int i = 0; i < patients.length; i++) {

			if (patients[i].getPatientId() == patientId) {

				appointment.setPatientId(patientId);

				for (int j = 0; j < doctors.length; j++) {

					if (doctors[j].getDoctorId() == docId) {

						appointment.setDoctorId(docId);

						appointment.setStatus("Pending");

						aprepo.save(appointment);

					}
					else {
						throw new DoctorNotFoundException("Doctor not Found");
					}

				}

			}

		}

		return appointment;
//			String response = restTemplate.getForObject(URL, String.class);
//
//			if(response == null) return null;
//			JSONObject result  = new JSONObject(response);
//			if(result.isNull("patient")) return null;
//			
//			JSONArray patients = result.getJSONArray("patients");
//			
//			
//			for(int i=0; i<patients.length(); i++) {
//				JSONObject res = patients.getJSONObject(i);
//				Patient patient = new Patient();
//				long patiuentid2 = (res.optString(patientId));
//				appointment.setPatient(patient);
//			}

	}

	@Override
	public int viewAllAcceptedAppointmentSummary() throws AppointmentNotFoundException {
		// TODO Auto-generated method stub
		List<Appointment> appointments = aprepo.getAllAcceptedAppointments();
		int aa = 0;
		if (appointments.isEmpty()) {
			throw new AppointmentNotFoundException("No appointments exist");
		} else {
			aa = appointments.size();
		}
		return aa;
	}

	@Override
	public int viewCancelledAppointmentSummary() throws AppointmentNotFoundException {
		// TODO Auto-generated method stub
		int ac = 0;
		List<Appointment> appointments = aprepo.getCancelledAppointments();
		if (appointments.isEmpty()) {
			throw new AppointmentNotFoundException("No appointments exist");
		} else {
			ac = appointments.size();
		}

		return ac;
	}

	@Override
	public List<AppointmentDto> viewAllAppointmentsDTO() throws AppointmentNotFoundException {
		// TODO Auto-generated method stub
		List<Appointment> appointments = aprepo.getAllAppointments();
		if (appointments.isEmpty()) {
			throw new AppointmentNotFoundException("No appointments exist");
		} else {
			AppointmentDto appointmentDto = new AppointmentDto();
			List<AppointmentDto> appointmentDtos = new ArrayList<AppointmentDto>();
			for (Appointment appointment : appointments) {
				appointmentDto = appointmentMapper.convertToDto(appointment);
				appointmentDtos.add(appointmentDto);
			}
			return appointmentDtos;
		}
	}

	@Override
	public List<AppointmentDto> viewFilterAppointmentsDTO(String status) throws AppointmentNotFoundException {
		// TODO Auto-generated method stub
		List<Appointment> appointments = aprepo.getFilteredAppointments(status);
		if (appointments.isEmpty()) {
			throw new AppointmentNotFoundException("No appointments exist");
		} else {
			AppointmentDto appointmentDto = new AppointmentDto();
			List<AppointmentDto> appointmentDtos = new ArrayList<AppointmentDto>();
			for (Appointment appointment : appointments) {
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
		List<Appointment> appointments = aprepo.viewCancelledAppointmentsForDoctor(id);
		if (appointments.isEmpty()) {
			throw new AppointmentNotFoundException("No appointments exist");
		} else {
			AppointmentDto appointmentDto = new AppointmentDto();
			List<AppointmentDto> appointmentDtos = new ArrayList<AppointmentDto>();
			for (Appointment appointment : appointments) {
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
		if (appointments.isEmpty()) {
			throw new AppointmentNotFoundException("No appointments exist");
		} else {
			AppointmentDto appointmentDto = new AppointmentDto();
			List<AppointmentDto> appointmentDtos = new ArrayList<AppointmentDto>();
			for (Appointment appointment : appointments) {
				appointmentDto = appointmentMapper.convertToDto(appointment);
				appointmentDtos.add(appointmentDto);
			}
			return appointmentDtos;
		}
	}

//	@Override
//	public List<AppointmentDto> viewAllAppointmentsForDoctor(long id) throws AppointmentNotFoundException {
//		// TODO Auto-generated method stub
//		List<Appointment> appointments = aprepo.viewAllAppointmentsForDoctor(id);
//		if (appointments.isEmpty()) {
//			throw new AppointmentNotFoundException("No appointments exist");
//		}
//
//		AppointmentDto appointmentDto = new AppointmentDto();
//		List<AppointmentDto> appointmentDtos = new ArrayList<AppointmentDto>();
//		for (Appointment appointment : appointments) {
//			appointmentDto = appointmentMapper.convertToDto(appointment);
//			appointmentDtos.add(appointmentDto);
//		}
//		return appointmentDtos;
//	}

	@Override
	public List<AppointmentDto> viewAcceptedAppointment(long id) throws AppointmentNotFoundException {
		List<Appointment> appointments = aprepo.viewAccptedAppointmentsForDoctor(id);
		if (appointments.isEmpty()) {
			throw new AppointmentNotFoundException("No appointments exist");
		} else {
			AppointmentDto appointmentDto = new AppointmentDto();
			List<AppointmentDto> appointmentDtos = new ArrayList<AppointmentDto>();
			for (Appointment appointment : appointments) {
				appointmentDto = appointmentMapper.convertToDto(appointment);
				appointmentDtos.add(appointmentDto);
			}
			return appointmentDtos;
		}
	}

	@Override
	public List<AppointmentDto> viewClosedAppointment(long id) throws AppointmentNotFoundException {
		List<Appointment> appointments = aprepo.viewClosedAppointmentsForDoctor(id);
		if (appointments.isEmpty()) {
			throw new AppointmentNotFoundException("No appointments exist");
		} else {
			AppointmentDto appointmentDto = new AppointmentDto();
			List<AppointmentDto> appointmentDtos = new ArrayList<AppointmentDto>();
			for (Appointment appointment : appointments) {
				appointmentDto = appointmentMapper.convertToDto(appointment);
				appointmentDtos.add(appointmentDto);
			}
			return appointmentDtos;
		}
	}

	@Override
	public List<AppointmentDto> ViewAllAppointmentsForTheDay(long id, String date) throws AppointmentNotFoundException {

		List<Appointment> appointments = aprepo.viewAppointmentsForDayForDoctor(date, id);
		if (appointments.isEmpty()) {
			throw new AppointmentNotFoundException("No appointments exist");
		} else {
			AppointmentDto appointmentDto = new AppointmentDto();
			List<AppointmentDto> appointmentDtos = new ArrayList<AppointmentDto>();
			for (Appointment appointment : appointments) {
				appointmentDto = appointmentMapper.convertToDto(appointment);
				appointmentDtos.add(appointmentDto);
			}
			return appointmentDtos;
		}
	}

	@Override
	public List<Appointment> viewAllAppointmentsByDoctorId(long id1) throws AppointmentNotFoundException {

		String URL1 = "http://localhost:8003/settings_doctor/getDoctor";

		boolean flag = false;

		ResponseEntity<Doctor[]> response = restTemplate.getForEntity(URL1, Doctor[].class);
		Doctor[] doctors = response.getBody();
		List<Appointment> appoint = null;
		for (int i = 0; i < doctors.length; i++) {

			if (doctors[i].getDoctorId() == id1) {

				appoint = aprepo.viewAllAppointmentsForDoctor(id1);

				flag = true;

			}

		}

		if (flag == false) {
			throw new AppointmentNotFoundException("Appointment List is Empty !");
		}

		return appoint;
	}
}
