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

	private int ques1;
	private int ques2;
	private int ques3;
	private int ques4;
	private String additionalComment;
	
}
