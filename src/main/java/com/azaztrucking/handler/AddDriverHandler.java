package com.azaztrucking.handler;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.azaztrucking.common.AzazTruckingCommonUtils;
import com.azaztrucking.doa.DriverDAO;
import com.azaztrucking.exception.AzazTruckingExceptions.GlobalExceptionHandler;
import com.azaztrucking.model.AzazTruckingRequest;
import com.azaztrucking.model.AzazTruckingResponse;
import com.azaztrucking.model.Driver;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class AddDriverHandler {

	private final DriverDAO driverDAO;
	private final ObjectMapper objectMapper;
	
	public AzazTruckingResponse addDriver(AzazTruckingRequest azazTruckingRequest) {
		
		log.debug("[BEGIN] - addDriver method: ");
		log.debug("Access Time :" + new Date());
		AzazTruckingResponse azazTruckingResponse = new AzazTruckingResponse();
		try {
			Driver driver = objectMapper.readValue(AzazTruckingCommonUtils.base64Decode(azazTruckingRequest.getEncodedMessage()), Driver.class);
			driverDAO.insertDriver(driver);
			
			prepareResponse(azazTruckingRequest, azazTruckingResponse);
			
		}catch(Exception ex) {
			log.error("Issue with addDriver method in AddDriverHandler class - {}", ex.getMessage());
			throw new GlobalExceptionHandler(ex.getMessage());
		}
		
		log.debug("[END] - addDriver method: ");
		return azazTruckingResponse;
		
	}

	private void prepareResponse(AzazTruckingRequest azazTruckingRequest, AzazTruckingResponse azazTruckingResponse) {
		String encodedMessage;
		azazTruckingResponse.setAzId(azazTruckingRequest.getAzId());
		  azazTruckingResponse.setCallerApplicationName(azazTruckingRequest.getCallerApplicationName());
		  azazTruckingResponse.setCallerId(azazTruckingRequest.getCallerId());
		  azazTruckingResponse.setTaskName(azazTruckingRequest.getTaskName());
		  azazTruckingResponse.setStatus("Success");
		  azazTruckingResponse.setCode("200");
		  encodedMessage = "driver added";
		  azazTruckingResponse.setEncodedMessage(AzazTruckingCommonUtils.base64Encode(encodedMessage));
	}
}
