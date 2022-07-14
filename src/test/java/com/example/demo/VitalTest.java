package com.example.demo;

import org.junit.jupiter.api.Test;
//
import com.cmd.appointment.entities.Prescription;
//
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
//
//
import org.junit.jupiter.api.BeforeEach;
//
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cmd.appointment.entities.Vital;
import com.cmd.appointment.repository.VitalRepository;
import com.cmd.appointment.service.VitalService;
import com.cmd.appointment.serviceImpl.VitalServiceImpl;

@ExtendWith(MockitoExtension.class)
public class VitalTest {
	//private MockMvc mockMvc;
	
	@Mock 
	private VitalRepository vrepo;
	
	
	VitalService vitalService; 
	
	
	@BeforeEach
    void initUseCase() {
		vitalService = new VitalServiceImpl(vrepo);
    }
	
	@Test
	public  void addVitalTest() throws Exception {
		Vital vital = new Vital();
		vital.setVitalId(0);
		vital.setTemperature(30);
		vital.setRespirationRate(95);
		vital.setECG(32);
		vital.setDiabetes(100);
		
		when(vrepo.save(any(Vital.class))).thenReturn(vital);
		Vital savedVital= vrepo.save(vital);
		assertThat(savedVital.getVitalId()).isNotNull();
	}
	}