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
public class CommentDto {

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private long commentId;
	private String commentDesc;
}
