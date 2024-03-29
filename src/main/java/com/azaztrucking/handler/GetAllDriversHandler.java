package com.azaztrucking.handler;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.azaztrucking.common.AzazTruckingCommonUtils;
import com.azaztrucking.doa.DriverDAO;
import com.azaztrucking.exception.AzazTruckingExceptions.GlobalExceptionHandler;
import com.azaztrucking.exception.AzazTruckingExceptions.ResourceNotFoundException;
import com.azaztrucking.model.AzazTruckingRequest;
import com.azaztrucking.model.AzazTruckingResponse;
import com.azaztrucking.model.Driver;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Component
@RequiredArgsConstructor
public class GetAllDriversHandler {

	private final DriverDAO driverDAO;
	private final ObjectMapper objectMapper;
	
	public AzazTruckingResponse getDrivers(AzazTruckingRequest azazTruckingRequest){
		log.debug("[BEGIN] - getDrivers method: ");
		log.debug("Access Time :" + new Date());
		
		AzazTruckingResponse azazTruckingResponse = new AzazTruckingResponse();
		
		try {
			List<Driver> listOfDrivers = driverDAO.findAllDrivers();
			if(listOfDrivers == null) return null;
			if(listOfDrivers.isEmpty()) {
				throw new ResourceNotFoundException("Not Found");
			}
			
			String encodedMessage = null;

			try {
				encodedMessage = objectMapper.writeValueAsString(listOfDrivers);
			} catch (JsonProcessingException e) {
				log.error("Issue with getDrivers method writeValueAsString - {}", e.getMessage());
			}
			prepareResponse(azazTruckingRequest, azazTruckingResponse, encodedMessage);
		}catch(Exception ex) {
			log.error("Issue with getDrivers method - {}", ex.getMessage());
			throw new GlobalExceptionHandler(ex.getMessage());
		}

		log.debug("[END] - getDrivers method: ");
		return azazTruckingResponse;
	}

	private void prepareResponse(AzazTruckingRequest azazTruckingRequest, AzazTruckingResponse azazTruckingResponse,
			String encodedMessage) {
		azazTruckingResponse.setAzId(azazTruckingRequest.getAzId());
		  azazTruckingResponse.setCallerApplicationName(azazTruckingRequest.getCallerApplicationName());
		  azazTruckingResponse.setCallerId(azazTruckingRequest.getCallerId());
		  azazTruckingResponse.setTaskName(azazTruckingRequest.getTaskName());
		  azazTruckingResponse.setStatus("Success");
		  azazTruckingResponse.setCode("200");
		  azazTruckingResponse.setEncodedMessage(AzazTruckingCommonUtils.base64Encode(encodedMessage));
	}
}
