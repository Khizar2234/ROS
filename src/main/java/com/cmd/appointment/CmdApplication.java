package com.cmd.appointment;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.cmd.appointment.mapper.AppointmentMapper;
import com.cmd.appointment.mapper.AppointmentMapperImpl;
import com.cmd.appointment.mapper.CommentMapper;
import com.cmd.appointment.mapper.CommentMapperImpl;
import com.cmd.appointment.mapper.FeedbackMapper;
import com.cmd.appointment.mapper.FeedbackMapperImpl;
import com.cmd.appointment.mapper.PrescriptionMapper;
import com.cmd.appointment.mapper.PrescriptionMapperImpl;
import com.cmd.appointment.mapper.RecommendationMapper;
import com.cmd.appointment.mapper.RecommendationMapperImpl;
import com.cmd.appointment.mapper.SymptomMapper;
import com.cmd.appointment.mapper.SymptomMapperImpl;
import com.cmd.appointment.mapper.TestMapper;
import com.cmd.appointment.mapper.TestMapperImpl;
import com.cmd.appointment.mapper.VitalMapper;
import com.cmd.appointment.mapper.VitalMapperImpl;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;


@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Appointment Service", version = "1.0", description = "API for Appointment Service"))
//@EnableEurekaClient
public class CmdApplication {

	public static void main(String[] args) {
		SpringApplication.run(CmdApplication.class, args);
	}
	
	@Bean
	public AppointmentMapper getAppointmentMapper() {
		return new AppointmentMapperImpl();
	}
	
	@Bean
	public PrescriptionMapper getPrescriptionMapper() {
		return new PrescriptionMapperImpl();
	}
	
	@Bean
	public CommentMapper getCommentMapper() {
		return new CommentMapperImpl();
	}
	
	@Bean
	public FeedbackMapper getFeedbackMapper() {
		return new FeedbackMapperImpl();
	}
	
	@Bean
	public RecommendationMapper getRecommendationMapper() {
		return new RecommendationMapperImpl();
	}
	
	@Bean
	public SymptomMapper getSymptomMapper() {
		return new SymptomMapperImpl();
	}
	
	@Bean
	public TestMapper getTestMapper() {
		return new TestMapperImpl();
	}
	
	@Bean
	public VitalMapper getVitalMapper(){
		return new  VitalMapperImpl();
	}
	
	@Bean
	   public RestTemplate getRestTemplate() {
	      return new RestTemplate();
}
}
