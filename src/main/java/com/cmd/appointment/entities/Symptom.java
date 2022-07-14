package com.cmd.appointment.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Symptom {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long symptomId;
	private String symptomName;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "appointmentId")
	private Appointment appointment;
}
