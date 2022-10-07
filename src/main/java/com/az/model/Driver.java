package com.az.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Driver {

	private Long id;
	private String last_name;
	private String first_name;
	private String email;
	private String phone;
	private String address;
	private Timestamp created_time;
}
