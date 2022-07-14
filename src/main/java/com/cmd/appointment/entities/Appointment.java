package com.cmd.appointment.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long appointmentId;
	private String appointmentDateTime;
	private String issue;
	private String regularity;
	private String status;
	
	@OneToOne
	@JoinColumn(name = "doctorId")
	private Doctor doctor;

	@OneToOne
	@JoinColumn(name = "patientId")
	private Patient patient;
}
