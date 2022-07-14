package com.cmd.appointment.dtos;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.cmd.appointment.entities.Appointment;
import com.cmd.appointment.entities.Feedback;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackDto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long feedbackId;
	private int a1;
	private int a2;
	private int a3;
	private int a4;
	private String feedbackComment;
	
}
