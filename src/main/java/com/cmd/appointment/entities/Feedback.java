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
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long feedbackId;
	private int a1;
	private int a2;
	private int a3;
	private int a4;
	private String feedbackComment;
	
	@OneToOne
	@JoinColumn(name = "appointmentId")
	private Appointment appointment;
}
