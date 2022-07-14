package com.cmd.appointment.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cmd.appointment.entities.Symptom;
import com.cmd.appointment.exception.SymptomAlreadyExistException;
import com.cmd.appointment.repository.SymptomRepository;
import com.cmd.appointment.service.SymptomService;

@Service
public class SymptomServiceImpl implements SymptomService {

	@Autowired
	private SymptomRepository symRepo;

	@Override
	public Symptom addSymptom(Symptom symptom) throws SymptomAlreadyExistException {
		// TODO Auto-generated method stub
		Symptom symptom1 = null;
		if(symRepo.existsById(symptom.getSymptomId())) {
			throw new SymptomAlreadyExistException("Symptom already exists. Please add new one..");
		}else {
			symptom1 = symRepo.save(symptom);
		}
		
		return symptom1;
	}
}
