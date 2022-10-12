package com.azaztrucking.service;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
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
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.azaztrucking.common.AzazTruckingCommonUtils;
import com.azaztrucking.doa.DriverDAO;
import com.azaztrucking.handler.AddDriverHandler;
import com.azaztrucking.handler.GetAllDriversHandler;
import com.azaztrucking.model.AzazTruckingRequest;
import com.azaztrucking.model.AzazTruckingResponse;
import com.azaztrucking.model.Driver;
import com.azaztrucking.service.AzazTruckingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
public class AzazTruckingServiceTest {
	


	@InjectMocks  AzazTruckingService azazTruckingService;
	@Mock private GetAllDriversHandler getAllDriversHandler;
	@Mock private AddDriverHandler addDriverHandler;
	
	@Test
	public void itShouldReturnGetAllDriversSuccessStatus() throws JsonMappingException, JsonProcessingException {
		String mockRequest = AzazTruckingCommonUtils.readFileAsString("/azaztrucking/azservice/GET_ALL_DRIVERS_REQUEST.json");
		ObjectMapper objectMapper = new ObjectMapper();
		AzazTruckingRequest azazTruckingRequest  = objectMapper.readValue(mockRequest, AzazTruckingRequest.class);
		
		AzazTruckingResponse expectedResponse = new AzazTruckingResponse();
		expectedResponse.setStatus("Success");
	
		when(getAllDriversHandler.getDrivers(Mockito.any())).thenReturn(expectedResponse);
		
		AzazTruckingResponse actualResponse = azazTruckingService.processAZInq(azazTruckingRequest);
		
		Assert.assertEquals(expectedResponse.getStatus(), actualResponse.getStatus());
		
//		verify(print, atLeastOnce()).printString(Mockito.anyString());
	}
	
	@Test
	public void itShouldReturnAddDriverSuccessStatus() throws JsonMappingException, JsonProcessingException {
		String mockRequest = AzazTruckingCommonUtils.readFileAsString("/azaztrucking/azservice/ADD_DRIVER_REQUEST.json");
		ObjectMapper objectMapper = new ObjectMapper();
		AzazTruckingRequest azazTruckingRequest  = objectMapper.readValue(mockRequest, AzazTruckingRequest.class);
		
		AzazTruckingResponse expectedResponse = new AzazTruckingResponse();
		expectedResponse.setStatus("Success");
	
		when(addDriverHandler.addDriver(Mockito.any())).thenReturn(expectedResponse);
		
		AzazTruckingResponse actualResponse = azazTruckingService.processAZInq(azazTruckingRequest);
		
		Assert.assertEquals(expectedResponse.getStatus(), actualResponse.getStatus());
	}
}
