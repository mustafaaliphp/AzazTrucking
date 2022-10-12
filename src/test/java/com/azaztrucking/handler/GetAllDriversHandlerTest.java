package com.azaztrucking.handler;

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

import com.azaztrucking.common.AzazTruckingCommonUtils;
import com.azaztrucking.doa.DriverDAO;
import com.azaztrucking.model.AzazTruckingRequest;
import com.azaztrucking.model.AzazTruckingResponse;
import com.azaztrucking.model.Driver;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
public class GetAllDriversHandlerTest {

	@InjectMocks private GetAllDriversHandler getAllDriversHandler;
	@Mock  private DriverDAO driverDAO;
	@Mock private ObjectMapper objectMapper;
	
	@Test
	public void itSouldReturnSuccessAzazTruckingResponse() throws JsonMappingException, JsonProcessingException {
		String mockRequest = AzazTruckingCommonUtils.readFileAsString("/azaztrucking/handler/GET_ALL_DRIVERS_REQUEST.json");
		ObjectMapper om = new ObjectMapper();
		AzazTruckingRequest azazTruckingRequest  = om.readValue(mockRequest, AzazTruckingRequest.class);
		
		List<Driver> listOfDrivers = new ArrayList<>();
		Driver driver = new Driver(1L,"Ali","Mustafa","","mm@mm.com","",new Timestamp(new Date().getTime())); 
		listOfDrivers.add(driver);
		
		AzazTruckingResponse expectedResponse = new AzazTruckingResponse();
		expectedResponse.setStatus("Success");
	
		when(driverDAO.findAllDrivers()).thenReturn(listOfDrivers);
		when(objectMapper.writeValueAsString(Mockito.any())).thenReturn("null");
		
		AzazTruckingResponse actualResponse = getAllDriversHandler.getDrivers(azazTruckingRequest);
		
		Assert.assertEquals(expectedResponse.getStatus(), actualResponse.getStatus());
	}
	
}
