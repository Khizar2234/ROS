package com.cmd.appointment.dtos;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long appointmentId;
	private String appointmentDateTime;
	private String issue;
	private String regularity;
	private String status;
}