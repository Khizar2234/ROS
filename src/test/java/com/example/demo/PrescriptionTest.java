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
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.cmd.appointment.repository.PrescriptionRepository;
import com.cmd.appointment.service.PrescriptionService;
import com.cmd.appointment.serviceImpl.PrescriptionServiceImpl;


//@SpringBootTest
@ExtendWith(MockitoExtension.class)
//@DataJpaTest
public class PrescriptionTest {

	@Mock
	private PrescriptionRepository preRepository;
	
	PrescriptionService prescriptionService;
	
	@BeforeEach
	void initUseCase() {
		prescriptionService = new PrescriptionServiceImpl(preRepository);
	}
	
	@Test
	public void addPrescriptionTest() {
		Prescription prescription = new Prescription();
		prescription.setPrescriptionId(2);
		prescription.setPrescriptionDetail("pre2");
		prescription.setMedicineTime("3.00");
		prescription.setMedicineName("Paracetamol");
		prescription.setMedicineDuration(2);
		prescription.setMedicineCycle("Everyday");
		
		when(preRepository.save(any(Prescription.class))).thenReturn(prescription);
		Prescription savedPrescription = preRepository.save(prescription);
		assertThat(savedPrescription.getPrescriptionId()).isNotNull();
		
	}
}
