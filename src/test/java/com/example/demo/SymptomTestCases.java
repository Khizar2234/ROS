package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cmd.appointment.entities.Appointment;
import com.cmd.appointment.entities.Doctor;
import com.cmd.appointment.entities.Patient;
import com.cmd.appointment.entities.Symptom;
import com.cmd.appointment.repository.SymptomRepository;
import com.cmd.appointment.service.SymptomService;
import com.cmd.appointment.serviceImpl.SymptomServiceImpl;

@ExtendWith(MockitoExtension.class)
public class SymptomTestCases {

	@Mock
	private SymptomRepository sRepo;
	
	SymptomService symptomService;
	
	@BeforeEach
	void initUseCase() {
		
		symptomService = new SymptomServiceImpl(sRepo);
	}
	
	@Test
	public void addSymptomTest() {
		
		Doctor doctor = new Doctor(0,"sad", 2134567, "saf","sdasf", "asfdsggf",0);
		
		Patient patient = new Patient(0, "saf", 30,"asfa","asd","asd","adsa",1242346,132, "aD", "SDA", "dfsdg", "dfsdf");
		
		Appointment appointment = new Appointment(0, "sdafd", "asd", "sadad", "sadfas",doctor,patient);
		
		Symptom symptom = new Symptom();
		
		symptom.setSymptomId(0);
		symptom.setSymptomName("Fever");
		symptom.setAppointment(appointment);
		
		when(sRepo.save(any(Symptom.class))).thenReturn(symptom);
		Symptom savedSymptom = sRepo.save(symptom);
		assertThat(savedSymptom.getSymptomId()).isNotNull();
	}
	
}
