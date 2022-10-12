package com.azaztrucking.handler;

import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.Assert;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import com.azaztrucking.common.AzazTruckingCommonUtils;
import com.azaztrucking.doa.DriverDAO;
import com.azaztrucking.model.AzazTruckingRequest;
import com.azaztrucking.model.AzazTruckingResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JdbcTest
public class AddDriverHandlerTest {

	@InjectMocks private AddDriverHandler addDriverHandler;
	@Mock  private DriverDAO driverDAO;
	@Mock private ObjectMapper objectMapper;
	
	@Test
	public void itSouldReturnSuccessAzazTruckingResponse() throws JsonMappingException, JsonProcessingException {
		String mockRequest = AzazTruckingCommonUtils.readFileAsString("/azaztrucking/handler/ADD_DRIVER_REQUEST.json");
		ObjectMapper objectMapper = new ObjectMapper();
		AzazTruckingRequest azazTruckingRequest  = objectMapper.readValue(mockRequest, AzazTruckingRequest.class);
		
		AzazTruckingResponse expectedResponse = new AzazTruckingResponse();
		expectedResponse.setStatus("Success");
	
		when(driverDAO.insertDriver(Mockito.any())).thenReturn(1);
		
		AzazTruckingResponse actualResponse = addDriverHandler.addDriver(azazTruckingRequest);
		
		Assert.assertEquals(expectedResponse.getStatus(), actualResponse.getStatus());
	}
}
