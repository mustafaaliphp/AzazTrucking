package com.azaztrucking.controller;

import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.Assert;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import com.azaztrucking.common.AzazTruckingCommonUtils;
import com.azaztrucking.model.AzazTruckingRequest;
import com.azaztrucking.model.AzazTruckingResponse;
import com.azaztrucking.service.AzazTruckingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
public class AzazTruckingControllerTest {

	@InjectMocks AzazTruckingController azazTruckingController;
	@Mock AzazTruckingService azazTruckingService;
	
	@Test
	public void itShouldSuccessResponseEntity() throws JsonMappingException, JsonProcessingException {
		String mockRequest = AzazTruckingCommonUtils.readFileAsString("/azaztrucking/controller/ADD_DRIVER_REQUEST.json");
		ObjectMapper objectMapper = new ObjectMapper();
		AzazTruckingRequest azazTruckingRequest  = objectMapper.readValue(mockRequest, AzazTruckingRequest.class);
		
		AzazTruckingResponse expectedResponse = new AzazTruckingResponse();
		expectedResponse.setStatus("Success");
	
		when(azazTruckingService.processAZInq(Mockito.any())).thenReturn(expectedResponse);
		
		AzazTruckingResponse actualResponse = azazTruckingService.processAZInq(azazTruckingRequest);
		
		Assert.assertEquals(expectedResponse.getStatus(), actualResponse.getStatus());
	}
}
