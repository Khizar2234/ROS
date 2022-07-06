package com.pratian.AppointmentService.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pratian.AppointmentService.Entities.Appointment;

@Repository
public interface IAppointmentRepo extends JpaRepository<Appointment, Long>{

}

