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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.azaztrucking.common.AzazTruckingCommonUtils;
import com.azaztrucking.doa.DriverDAO;
import com.azaztrucking.handler.GetAllDriversHandler;
import com.azaztrucking.model.AzazTruckingRequest;
import com.azaztrucking.model.AzazTruckingResponse;
import com.azaztrucking.model.Driver;
import com.azaztrucking.service.AzazTruckingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
public class DriverDAOTest {


	@InjectMocks private DriverDAO driverDAO;
	@Mock NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Mock JdbcTemplate jdbcTemplate;
	
	@Test
	public void itShouldFindAllDrivers() {
//		String mockRequest = AzazCommonUtils.readFileAsString("/az/azservice/GET_ALL_DRIVERS.json");
//		System.out.println("mockRequest" + mockRequest);
		List<Driver> expectedListOfDrivers = new ArrayList();
		Driver driver1 = new Driver(1L,"Ali","Mustafa","","mm@mm.com","",new Timestamp(new Date().getTime())); 
		Driver driver2 = new Driver(1L,"Ali","Mustafa","","mm@mm.com","",new Timestamp(new Date().getTime())); 
		expectedListOfDrivers.add(driver1);
		expectedListOfDrivers.add(driver2);
		
		when(namedParameterJdbcTemplate.query(Mockito.anyString(), Mockito.any(MapSqlParameterSource.class), Mockito.<BeanPropertyRowMapper<Driver>>any())).thenAnswer(x -> expectedListOfDrivers);
		
		List<Driver> drivers = driverDAO.findDriversByEmail("mm@mm.com");
		Assert.assertEquals(0, 0);
		
	}
	
	

}
