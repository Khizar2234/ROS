package com.cmd.appointment.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cmd.appointment.dtos.CommentDto;
import com.cmd.appointment.entities.Comment;
import com.cmd.appointment.exception.AppointmentNotFoundException;
import com.cmd.appointment.exception.CommentAlreadyExistException;
import com.cmd.appointment.exception.CommentNotFoundException;
import com.cmd.appointment.mapper.CommentMapper;
import com.cmd.appointment.repository.AppointmentRepository;
import com.cmd.appointment.repository.CommentRepository;
import com.cmd.appointment.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository comRepo;

	@Autowired
	private AppointmentRepository appRepo;

	@Autowired
	private CommentMapper commentMapper;
	
	@Override
	public Comment addComment(Comment comment) throws CommentAlreadyExistException {
		// TODO Auto-generated method stub
		Comment comment1 = null;
		if (comRepo.existsById(comment.getCommentId())) {
			throw new CommentAlreadyExistException("Comment already exists");
		} else {
			// TODO: handle exception
			comment1 = comRepo.save(comment);
		}
		return comment1;
	}

	@Override
	public Comment editComment(Comment comment) throws CommentNotFoundException {
		// TODO Auto-generated method stub
		Comment comment1 = null;
		if (comRepo.existsById(comment.getCommentId())) {
			comment1.setCommentDesc(comment.getCommentDesc());
			comRepo.save(comment1);
		} else {
			// TODO: handle exception
			throw new CommentNotFoundException("Comment Doesn't exists");
		}
		return comment1;
	}

	@Override
	public CommentDto viewCommentByAppId(long aid) throws AppointmentNotFoundException {
		// TODO Auto-generated method stub
		if (appRepo.existsById(aid)) {
			Comment comment = comRepo.getCommentByAppId(aid);
			CommentDto commentDto = new CommentDto();
			commentDto = commentMapper.convertToDto(comment);
			return commentDto;
		} else {
			throw new AppointmentNotFoundException("Appointment not found");
		}
	}
}
