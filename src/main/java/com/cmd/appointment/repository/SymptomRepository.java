package com.cmd.appointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmd.appointment.entities.Symptom;

@Repository
public interface SymptomRepository extends JpaRepository<Symptom, Long>{
	
}
