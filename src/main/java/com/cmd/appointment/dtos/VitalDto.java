package com.cmd.appointment.dtos;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VitalDto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long vitalId;
	private int ECG;
	private float temperature;
	private int diabetes;
	private int respirationRate;
}
