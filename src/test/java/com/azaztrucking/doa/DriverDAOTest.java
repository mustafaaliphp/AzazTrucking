package com.azaztrucking.doa;

import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.Assert;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import com.azaztrucking.model.Driver;

@JdbcTest
public class DriverDAOTest {

	@InjectMocks private DriverDAO driverDAO;
	@Mock private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Mock private JdbcTemplate jdbcTemplate;
	
	@Test
	public void itShouldInsertDriver() {
		int expectedResponse = 1;
		Driver driver = new Driver(1L,"Ali","Mustafa","","mm@mm.com","",new Timestamp(new Date().getTime()));
		when(namedParameterJdbcTemplate.update(Mockito.anyString(), 
				Mockito.<BeanPropertySqlParameterSource>any())).thenAnswer(x -> expectedResponse);
		int actualResponse = driverDAO.insertDriver(driver);
		Assert.assertEquals(expectedResponse, actualResponse);
	}
	
	@Test
	public void itShouldFindAllDrivers() {
		List<Driver> expectedResponse = new ArrayList<>();
		Driver driver1 = new Driver(1L,"Ali","Mustafa","","mm@mm.com","",new Timestamp(new Date().getTime())); 
		Driver driver2 = new Driver(1L,"Ali","Mustafa","","mm@mm.com","",new Timestamp(new Date().getTime())); 
		expectedResponse.add(driver1);
		expectedResponse.add(driver2);
		
		when(jdbcTemplate.query(Mockito.anyString(),
				Mockito.<BeanPropertyRowMapper<Driver>>any())).thenAnswer(x -> expectedResponse);
		
		List<Driver> actualResponse = driverDAO.findAllDrivers();
		Assert.assertEquals(expectedResponse.get(0).getEmail(), actualResponse.get(0).getEmail());
	}
	@Test
	public void itShouldFindDriverById() {
		Driver expectedResponse = new Driver(1L,"Ali","Mustafa","","mm@mm.com","",new Timestamp(new Date().getTime()));
		when(namedParameterJdbcTemplate.queryForObject(Mockito.anyString(), 
				Mockito.any(MapSqlParameterSource.class), 
				Mockito.<BeanPropertyRowMapper<Driver>>any())).thenAnswer(x -> expectedResponse);
		Driver actualResponse = driverDAO.findDriverById(1L);
		Assert.assertEquals(expectedResponse, actualResponse);
	}
	
	@Test
	public void itShouldFindAllDriversByEmail() {
		List<Driver> expectedResponse = new ArrayList<>();
		Driver driver1 = new Driver(1L,"Ali","Mustafa","","mm@mm.com","",new Timestamp(new Date().getTime())); 
		Driver driver2 = new Driver(1L,"Ali","Mustafa","","mm@mm.com","",new Timestamp(new Date().getTime())); 
		expectedResponse.add(driver1);
		expectedResponse.add(driver2);
		
		when(namedParameterJdbcTemplate.query(Mockito.anyString(), 
				Mockito.any(MapSqlParameterSource.class), 
				Mockito.<BeanPropertyRowMapper<Driver>>any())).thenAnswer(x -> expectedResponse);
		
		List<Driver> actualResponse = driverDAO.findDriversByEmail("mm@mm.com");
		Assert.assertEquals(expectedResponse.get(0).getEmail(), actualResponse.get(0).getEmail());
	}
}
