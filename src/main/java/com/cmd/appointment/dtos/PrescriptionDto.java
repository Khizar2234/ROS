package com.cmd.appointment.dtos;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionDto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long prescriptionId;
	private String prescriptionDetail;
	private String medicineName;
	private int medicineDuration;
	private String medicineCycle;
	private String medicineTime;

}
