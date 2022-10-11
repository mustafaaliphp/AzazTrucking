package com.azaztrucking.doa;


import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.azaztrucking.model.Driver;

import org.apache.commons.io.IOUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class DriverDAO {

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int insertDriver(Driver driver) {
		driver.setCreated_time(new Timestamp(new Date().getTime()));
		String sql = "insert into drivers (id, last_name, first_name, email, phone, address, created_time) "
				+ "value(:id, :last_name, :first_name, :email, :phone, :address, :created_time)";
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(driver);
		int insertedRow =  namedParameterJdbcTemplate.update(sql, params);
		return insertedRow;
		
	}
	
	public List<Driver> findAllDrivers(){
		String aqlFromFile;
		try {
			InputStream is = DriverDAO.class.getResourceAsStream("/sql/allDriver.sql");
			aqlFromFile = IOUtils.toString(is, StandardCharsets.UTF_8);
			
		}catch(IOException e) {
			throw new IllegalArgumentException("SQL File not proper - " + e.getMessage());
		}
		String sql = "select * from drivers";
		List<Driver> drivers = jdbcTemplate.query(aqlFromFile,new BeanPropertyRowMapper<>(Driver.class));
		return drivers;
	}
	
	public Driver findDriver(Long driverID) {
		
		   String sql = "select * from drivers WHERE driver_id : driverID";
		   MapSqlParameterSource parameters = new MapSqlParameterSource();
		   parameters.addValue("driverID", driverID);
		   Driver driver =  (Driver) namedParameterJdbcTemplate.query(sql, parameters, new BeanPropertyRowMapper<>(Driver.class));
		   return driver;
		
	}
	
	public List<Driver> findDriversByEmail(String email) {
		
		   String sql = "select * from drivers WHERE email = :email";
		   MapSqlParameterSource parameters = new MapSqlParameterSource();
		   parameters.addValue("email", email);
		   List<Driver> drivers =   namedParameterJdbcTemplate.query(sql, parameters, new BeanPropertyRowMapper<Driver>(Driver.class));
		   return drivers;
		
	}
}
