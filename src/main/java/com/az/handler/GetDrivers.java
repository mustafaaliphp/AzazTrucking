package com.az.handler;

import java.util.List;

import org.springframework.stereotype.Component;

import com.az.common.AzazCommonUtils;
import com.az.doa.DriverDAO;
import com.az.exception.ResourceNotFoundException;
import com.az.model.AzRequest;
import com.az.model.AzResponse;
import com.az.model.Driver;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Component
@Slf4j
public class GetDrivers {

	private final DriverDAO driverDAO;
	private final ObjectMapper objectMapper;
	
	public AzResponse getDrivers(AzRequest azRequest){
		AzResponse azResponse = new AzResponse();
		List<Driver> listOfDrivers = driverDAO.findAllDrivers();
		if(listOfDrivers == null) return null;
		if(listOfDrivers.isEmpty()) {
			throw new ResourceNotFoundException("Not Found");
		}
		
		String encodedMessage = null;

		try {
			encodedMessage = objectMapper.writeValueAsString(listOfDrivers);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  azResponse.setAzId(azRequest.getAzId());
		  azResponse.setCallerApplicationName(azRequest.getCallerApplicationName());
		  azResponse.setCallerId(azRequest.getCallerId());
		  azResponse.setTaskName(azRequest.getTaskName());
		  azResponse.setEncodedMessage(AzazCommonUtils.base64Encode(encodedMessage));
		
		return azResponse;
	}
}
