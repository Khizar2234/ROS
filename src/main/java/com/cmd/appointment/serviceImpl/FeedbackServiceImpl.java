package com.cmd.appointment.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmd.appointment.dtos.FeedbackDto;
import com.cmd.appointment.entities.Feedback;
import com.cmd.appointment.exception.AppointmentNotFoundException;
import com.cmd.appointment.mapper.FeedbackMapper;
import com.cmd.appointment.repository.AppointmentRepository;
import com.cmd.appointment.repository.FeedbackRepository;
import com.cmd.appointment.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService{

	@Autowired
	private FeedbackRepository fbrepo;
	
	@Autowired
	private AppointmentRepository apRepo;
	
	@Autowired
	private FeedbackMapper feedbackMapper;

	@Override
	public FeedbackDto getFeedbackByAppointmentId(long id) throws AppointmentNotFoundException {
		// TODO Auto-generated method stub
		if (apRepo.existsById(id)) {
			 Feedback feedback1 = fbrepo.getFeedackByAppId(id);
			 FeedbackDto feedbackDto = feedbackMapper.convertToDto(feedback1);
			 return feedbackDto;
		} else {
			throw new AppointmentNotFoundException("Appointment not found");
		}
	}
	


}
