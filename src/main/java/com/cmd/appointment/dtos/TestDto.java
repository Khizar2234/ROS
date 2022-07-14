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
public class TestDto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long testId;
	private String testName;
}
