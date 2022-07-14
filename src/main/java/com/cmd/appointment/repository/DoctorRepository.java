package com.cmd.appointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmd.appointment.entities.Comment;
import com.cmd.appointment.entities.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
