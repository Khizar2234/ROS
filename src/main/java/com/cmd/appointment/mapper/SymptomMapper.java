package com.cmd.appointment.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cmd.appointment.dtos.SymptomDto;
import com.cmd.appointment.entities.Symptom;

@Mapper
public interface SymptomMapper {

	@Mapping(source = "symptomId", target = "symptomId")
	@Mapping(source = "symptomName", target = "symptomName")
	public SymptomDto convertToDto(Symptom symptom);
}
