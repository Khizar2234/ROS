package com.cmd.appointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cmd.appointment.entities.Feedback;


@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long>{

	@Query(value="SELECT * FROM feedback where appointment_id=:id",nativeQuery = true)
	public Feedback getFeedackByAppId(@Param (value = "id") long id);
}
