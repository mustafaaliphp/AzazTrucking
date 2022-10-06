package com.azaztrucking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter 
@Setter

public class LogInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String class_name;
	private String function_name;
	private String request;
	private String response;
	private String exception;
	
}
