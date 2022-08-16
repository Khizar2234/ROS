//package com.cmd.appointment.mapper;
//
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//
//import com.cmd.appointment.dtos.FeedbackDto;
//import com.cmd.appointment.entities.Feedback;
//
//@Mapper
//public interface FeedbackMapper {
//
//	@Mapping(source = "feedbackId", target = "feedbackId")
//	@Mapping(source = "a1", target = "a1")
//	@Mapping(source = "a2", target = "a2")
//	@Mapping(source = "a3", target = "a3")
//	@Mapping(source = "a4", target = "a4")
//	@Mapping(source = "feedbackComment", target = "feedbackComment")
//	public FeedbackDto convertToDto(Feedback feedback);
//}