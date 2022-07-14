package com.cmd.appointment.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vital {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long vitalId;
	private int ECG;
	private float temperature;
	private int diabetes;
	private int respirationRate;
	
	@OneToOne
	@JoinColumn(name = "appointmentId")
	private Appointment appointment;
}